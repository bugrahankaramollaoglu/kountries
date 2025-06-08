package com.bugrahankaramollaoglu.countries.adapter

import android.view.View
import com.bugrahankaramollaoglu.countries.model.Country

interface CountryClickListener {
    fun onCountryClicked(v: View, country: Country)
}