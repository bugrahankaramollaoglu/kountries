package com.bugrahankaramollaoglu.countries.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bugrahankaramollaoglu.countries.adapter.CountryAdapter.CountryViewHolder
import com.bugrahankaramollaoglu.countries.databinding.KountryItemBinding
import com.bugrahankaramollaoglu.countries.model.Country
import com.bugrahankaramollaoglu.countries.view.FeedFragmentDirections
import androidx.navigation.findNavController
import com.bugrahankaramollaoglu.countries.R

class CountryAdapter(val countryList: ArrayList<Country>) :
    RecyclerView.Adapter<CountryViewHolder>(), CountryClickListener {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
//        val binding = KountryItemBinding.inflate(inflater, parent, false)
        val view =
            DataBindingUtil.inflate<KountryItemBinding>(
                inflater,
                R.layout.kountry_item,
                parent,
                false
            )
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {

        // databinding sayesinde aşağıdaki blok yerine bu satır yetiyor
        holder.view.country = countryList[position]
        holder.view.listener = this

        /*val country = countryList[position]
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
        )*/

    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    class CountryViewHolder(var view: KountryItemBinding) : RecyclerView.ViewHolder(view.root) {

    }

    fun updateCountryList(newCountrylist: List<Country>) {
        countryList.clear()
        countryList.addAll(newCountrylist)
        notifyDataSetChanged()
    }

    override fun onCountryClicked(v: View, country: Country) {
        val action = FeedFragmentDirections.actionFeedFragmentToCountryFragment()
        action.countryUuid = country.uuid
        v.findNavController().navigate(action)
    }

}