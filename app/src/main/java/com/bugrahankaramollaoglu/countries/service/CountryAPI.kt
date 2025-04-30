package com.bugrahankaramollaoglu.countries.service

import com.bugrahankaramollaoglu.countries.model.Country
import io.reactivex.Single
import retrofit2.http.GET

/* api'ı json'dan cekmek için 2 dosyaya ihtiyacın var
* 1) Arayüz (Interface)
* 2) Servis (Retrofit Objesi)
*
* */

interface CountryAPI {

    // https://raw.githubusercontent.com
    // atilsamancioglu/IA19-DataSetCountries/refs/heads/master/countrydataset.json

    /* why did we use Single instead of Observable?
    *
    * Observable type of fetching data from an API means
    * that the data should be constantly fetched like a crypto api
    * single means that we only fetch it once and for all
    *
    * */


    // buraya extensionUrl yazilir (BaseUrl devami)
    @GET("atilsamancioglu/IA19-DataSetCountries/refs/heads/master/countrydataset.json")
    fun getCountries(): Single<List<Country>>

}