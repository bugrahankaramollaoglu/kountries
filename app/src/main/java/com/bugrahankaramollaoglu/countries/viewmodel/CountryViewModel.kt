package com.bugrahankaramollaoglu.countries.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bugrahankaramollaoglu.countries.model.Country

class CountryViewModel : ViewModel() {

    val countryLiveData= MutableLiveData<Country> ()
    fun getDataFromRoom() {
        val dummyCountry = Country("Turkey","Asya","Ankara","TRY","Turkish",".com")
        countryLiveData.value = dummyCountry
    }

}