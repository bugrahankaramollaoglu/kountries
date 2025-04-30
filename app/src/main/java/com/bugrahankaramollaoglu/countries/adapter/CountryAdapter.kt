package com.bugrahankaramollaoglu.countries.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bugrahankaramollaoglu.countries.adapter.CountryAdapter.CountryViewHolder
import com.bugrahankaramollaoglu.countries.databinding.KountryItemBinding
import com.bugrahankaramollaoglu.countries.model.Country

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