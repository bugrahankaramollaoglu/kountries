package com.bugrahankaramollaoglu.countries.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bugrahankaramollaoglu.countries.R
import com.bugrahankaramollaoglu.countries.databinding.FragmentCountryBinding
import com.bugrahankaramollaoglu.countries.util.downloadFromUrl
import com.bugrahankaramollaoglu.countries.util.placeholderProgressBar
import com.bugrahankaramollaoglu.countries.viewmodel.CountryViewModel
import com.bugrahankaramollaoglu.countries.viewmodel.FeedViewModel
import kotlin.getValue


class CountryFragment : Fragment() {

    private lateinit var viewModel: CountryViewModel
    private var countryUuid = 0


    private lateinit var binding: FragmentCountryBinding // databinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_country, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            countryUuid = CountryFragmentArgs.fromBundle(it).countryUuid
        }

        viewModel = ViewModelProviders.of(this).get(CountryViewModel::class.java)
        viewModel.getDataFromRoom(countryUuid)

        observeLiveData()
    }

    private fun observeLiveData() {

        viewModel.countryLiveData.observe(viewLifecycleOwner, Observer { country ->
            country?.let {

                binding.selectedCountry = country

                /*
                    data binding yaptıgın için bunlara gerek kalmadı

                    binding.countryName.text = country.countryName
                    binding.countryCapital.text = country.countryCapital
                    binding.countryCurrency.text = country.countryCurrency
                    binding.countryLanguage.text = country.countryLanguage
                    binding.countryRegion.text = country.countryRegion

                    binding.countryImage.downloadFromUrl(
                        country.imageUrl,
                        placeholderProgressBar(requireContext())
                    )
                */

                /*context?.let {
                    binding.countryImage.downloadFromUrl(
                        country.imageUrl,
                        placeholderProgressBar(it)
                    )
                }*/
            }

        })

    }
}