package com.bugrahankaramollaoglu.countries.service

import com.bugrahankaramollaoglu.countries.model.Country
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class CountryApiService {

    // https://raw.githubusercontent.com
    // atilsamancioglu/IA19-DataSetCountries/refs/heads/master/countrydataset.json

    private val BASE_URL = "https://raw.githubusercontent.com/"

    // api'yi cekecek arayüzü yazdik simdi tutacak servisi yazmamiz lazim retrofit objesi olarak
    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL) // base url'sini nereden alacagını
        .addConverterFactory(GsonConverterFactory.create()) // json kullanacagımızı
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // rxJava kullanacagımızı söylememiz gerekiyor
        .build()
        .create(CountryAPI::class.java)

    fun getData(): Single<List<Country>> {
        return api.getCountries()
    }
}