package com.bugrahankaramollaoglu.countries.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bugrahankaramollaoglu.countries.model.Country
import com.bugrahankaramollaoglu.countries.service.CountryApiService
import com.bugrahankaramollaoglu.countries.service.CountryDatabase
import com.bugrahankaramollaoglu.countries.util.CustomSharedPreferences
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch

class FeedViewModel(application: Application) : BaseViewModel(application) {

    val countries = MutableLiveData<List<Country>>()
    val countryError = MutableLiveData<Boolean>()
    val countryLoading = MutableLiveData<Boolean>()
    private val countryApiService = CountryApiService()
    private var customPreference = CustomSharedPreferences(getApplication())
    private var refreshTime = 10 * 60 * 1000 * 1000 * 1000L

    // hafizayi verimli kullanmayi saglayan trash mekanizmasi.
    // her api kullandiginda kullansan iyi olur
    private val disposable = CompositeDisposable()

    fun refreshData() {

        val updateTime = customPreference.getTime()
        if (updateTime != null && updateTime != 0L && System.nanoTime() - updateTime < refreshTime) {
            getDataFromSQLite()
        } else {
            getDataFromAPI()
        }
    }

    fun refreshFromAPI() {
        getDataFromAPI()
    }

    private fun getDataFromSQLite() {
        countryLoading.value = true

        launch {
            val countries = CountryDatabase(getApplication()).countryDao().getAllCountries()
            showCountries(countries)
            Toast.makeText(getApplication(), "Countries from SQLite", Toast.LENGTH_SHORT).show()
        }
    }

    private fun getDataFromAPI() {

        countryLoading.value = true
        disposable.add(
            countryApiService.getData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<Country>>() {
                    override fun onSuccess(t: List<Country>) {

                        storeInSQLite(t)
                        Toast.makeText(getApplication(), "Countries from API", Toast.LENGTH_SHORT)
                            .show()

                    }

                    override fun onError(e: Throwable) {
                        countryError.value = true
                        countryLoading.value = false
                        e.printStackTrace()
                    }
                })
        )

    }

    private fun showCountries(countryList: List<Country>) {
        countries.value = countryList
        countryError.value = false
        countryLoading.value = false
    }

    private fun storeInSQLite(list: List<Country>) {

        launch {

            val dao = CountryDatabase(getApplication()).countryDao()
            dao.deleteAllCountries()
            val listLong = dao.insertAll(*list.toTypedArray())
            var i = 0
            while (i < list.size) {
                list[i].uuid = listLong[i].toInt()
                i += 1
            }

            showCountries(list)

        }

        customPreference.saveTime(System.nanoTime())

    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

}