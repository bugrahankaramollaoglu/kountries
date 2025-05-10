package com.bugrahankaramollaoglu.countries.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bugrahankaramollaoglu.countries.adapter.CountryAdapter.CountryViewHolder
import com.bugrahankaramollaoglu.countries.databinding.KountryItemBinding
import com.bugrahankaramollaoglu.countries.model.Country
import com.bugrahankaramollaoglu.countries.view.FeedFragmentDirections
import androidx.navigation.findNavController
import com.bugrahankaramollaoglu.countries.util.downloadFromUrl
import com.bugrahankaramollaoglu.countries.util.placeholderProgressBar

class CountryAdapter(val countryList: ArrayList<Country>) :
    RecyclerView.Adapter<CountryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = KountryItemBinding.inflate(inflater, parent, false)
        return CountryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val country = countryList[position]
        holder.binding.countryNameText.text = country.countryName
        holder.binding.countryRegionText.text = country.countryRegion

        holder.itemView.setOnClickListener {
            val action = FeedFragmentDirections.actionFeedFragmentToCountryFragment()
            action.countryUuid = countryList[position].uuid
            it.findNavController().navigate(action)
        }

        holder.binding.countryView.downloadFromUrl(
            countryList[position].imageUrl,
            placeholderProgressBar(holder.itemView.context)
        )

    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    class CountryViewHolder(val binding: KountryItemBinding) : RecyclerView.ViewHolder(binding.root)

    fun updateCountryList(newCountrylist: List<Country>) {
        countryList.clear()
        countryList.addAll(newCountrylist)
        notifyDataSetChanged()
    }

}