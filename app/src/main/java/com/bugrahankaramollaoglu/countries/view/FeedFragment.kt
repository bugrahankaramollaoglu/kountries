package com.bugrahankaramollaoglu.countries.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.bugrahankaramollaoglu.countries.adapter.CountryAdapter
import com.bugrahankaramollaoglu.countries.databinding.FragmentFeedBinding
import com.bugrahankaramollaoglu.countries.viewmodel.FeedViewModel


class FeedFragment : Fragment() {

    private lateinit var binding: FragmentFeedBinding
    private lateinit var viewModel : FeedViewModel
    private val countryAdapter = CountryAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        binding = FragmentFeedBinding.inflate(inflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val viewModel: FeedViewModel by viewModels()



    }
}