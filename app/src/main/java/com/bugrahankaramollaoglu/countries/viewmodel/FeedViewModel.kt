package com.bugrahankaramollaoglu.countries.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bugrahankaramollaoglu.countries.model.Country
import com.bugrahankaramollaoglu.countries.service.CountryApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class FeedViewModel : ViewModel() {

    val countries = MutableLiveData<List<Country>>()

    val countryError = MutableLiveData<Boolean>()

    val countryLoading = MutableLiveData<Boolean>()

    private val countryApiService = CountryApiService()

    // hafizayi verimli kullanmayi saglayan trash mekanizmasi.
    // her api kullandiginda kullansan iyi olur
    private val disposable = CompositeDisposable()


    fun refreshData() {
        // dummy data
        /*val country = Country("Turkey", "Asia", "Ankara", "TRY", "Türkçe", ".com")
        val country2 = Country("Fransa", "Europe", "Paris", "EUR", "French", ".com")
        val country3 = Country("Almanya", "Asia", "Berlin", "EUR", "Deutsch", ".com")

        var countryList = arrayListOf<Country>(country, country2, country3)
        countries.value = countryList
        countryError.value = true
        countryLoading.value = false*/


        getDataFromAPI()
    }

    private fun getDataFromAPI() {

        countryLoading.value = true
        disposable.add(
            countryApiService.getData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<Country>>() {
                    override fun onSuccess(t: List<Country>) {
                        countries.value = t
                        countryError.value = false
                        countryLoading.value = false
                    }

                    override fun onError(e: Throwable) {
                        countryError.value = true
                        countryLoading.value = false
                        e.printStackTrace()
                    }
                })
        )

    }

}