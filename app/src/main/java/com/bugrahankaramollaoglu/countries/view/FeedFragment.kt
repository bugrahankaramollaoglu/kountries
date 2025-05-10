package com.bugrahankaramollaoglu.countries.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bugrahankaramollaoglu.countries.adapter.CountryAdapter
import com.bugrahankaramollaoglu.countries.databinding.FragmentFeedBinding
import com.bugrahankaramollaoglu.countries.viewmodel.FeedViewModel
import kotlin.getValue

class FeedFragment : Fragment() {

    private lateinit var binding: FragmentFeedBinding
    private val viewModel: FeedViewModel by viewModels()
    private val countryAdapter = CountryAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentFeedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.refreshData()

        binding.countryList.layoutManager = LinearLayoutManager(context)
        binding.countryList.adapter = countryAdapter

        binding.swiperefresh.setOnRefreshListener {
            binding.countryList.visibility = View.GONE
            binding.countryErrorText.visibility = View.GONE
            binding.countryLoadingBar.visibility = View.VISIBLE
            viewModel.refreshFromAPI()
            binding.swiperefresh.isRefreshing = false
        }

        observeLiveData()

    }

    private fun observeLiveData() {
        viewModel.countries.observe(viewLifecycleOwner) { countries ->
            countries?.let {
                println("Countries data received: $countries") // Add this
                binding.countryList.visibility = View.VISIBLE
                countryAdapter.updateCountryList(it)
            }
        }

        viewModel.countryLoading.observe(viewLifecycleOwner) { loading ->
            loading?.let {
                if (it) {
                    binding.countryLoadingBar.visibility = View.VISIBLE
                    binding.countryErrorText.visibility = View.GONE
                    binding.countryList.visibility = View.GONE
                } else {
                    binding.countryLoadingBar.visibility = View.GONE
                }
            }
        }

        viewModel.countryError.observe(viewLifecycleOwner) { error ->
            binding.countryErrorText.visibility = if (error == true) View.VISIBLE else View.GONE
        }
    }
}
