package com.bugrahankaramollaoglu.countries.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bugrahankaramollaoglu.countries.model.Country

class FeedViewModel : ViewModel() {

    val countries = MutableLiveData<List<Country>>()

    val countryError = MutableLiveData<Boolean>()

    val countryLoading = MutableLiveData<Boolean>()

    fun refreshData() {
        val country = Country("Turkey", "Asia", "Ankara", "TRY", "Türkçe", ".com")
        val country2 = Country("Fransa", "Europe", "Paris", "EUR", "French", ".com")
        val country3 = Country("Almanya", "Asia", "Berlin", "EUR", "Deutsch", ".com")

        var countryList = arrayListOf<Country>(country, country2, country3)
        countries.value = countryList
        countryError.value = true
        countryLoading.value = false
    }

}