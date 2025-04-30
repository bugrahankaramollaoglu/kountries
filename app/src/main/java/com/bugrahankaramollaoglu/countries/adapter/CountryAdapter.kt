package com.bugrahankaramollaoglu.countries.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bugrahankaramollaoglu.countries.R
import com.bugrahankaramollaoglu.countries.adapter.CountryAdapter.CountryViewHolder
import com.bugrahankaramollaoglu.countries.model.Country

class CountryAdapter(val countryList: ArrayList<Country>) :
    RecyclerView.Adapter<CountryViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CountryViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.kountry_item, parent, false)
        return CountryViewHolder(view)

    }

    override fun onBindViewHolder(
        holder: CountryViewHolder,
        position: Int
    ) {

        holder.view.countryNameText = countryList[position].countryName


    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    class CountryViewHolder(var view: View) : RecyclerView.ViewHolder(view) {

    }


}