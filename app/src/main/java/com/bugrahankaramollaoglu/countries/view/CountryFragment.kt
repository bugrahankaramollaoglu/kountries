package com.bugrahankaramollaoglu.countries.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.bugrahankaramollaoglu.countries.R
import com.bugrahankaramollaoglu.countries.viewmodel.CountryViewModel
import com.bugrahankaramollaoglu.countries.viewmodel.FeedViewModel
import kotlin.getValue


class CountryFragment : Fragment() {

    private var countryUuid = 0
    private val viewModel: CountryViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_country, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel.getDataFromRoom()

        arguments?.let {
            countryUuid = CountryFragmentArgs.fromBundle(it).countryUuid
        }

        observeLiveData()
    }

    private fun observeLiveData() {

        viewModel.countryLiveData.observe(viewLifecycleOwner, Observer { country ->
            country?.let {
                it.countryName = country.countryName
                it.countryRegion = country.countryRegion
                it.countryCapital = country.countryCapital
                it.countryCurrency = country.countryCurrency
                it.countryLanguage = country.countryLanguage
            }

        })

    }

}