package com.bugrahankaramollaoglu.countries.model

import com.google.gson.annotations.SerializedName

/* data class ile class farkı:
* data class otomatik olarak equals(), toString(), copy() gibi
* fonksiyonlarla gelir, normal class olarak tanımlarsan
* bunları manuel olarak yazman gerekir.
* ayrıca data class'a constructor vermek zorundasın,
* class'ta boş bıraksan da olur
* also you cannot inherit from a data class
*
* */

data class Country(

    /* serializedName, json apiden veri cekerken
    * apideki key'lerle seninkiler ayni degilse (ki genelde farklı
    * kullanilir) keyleri baglamak icin kullanılır. serailzedname icine
    * yazdigin api keyiyle birebir ayni olmalidir */

    @SerializedName("name")
    var countryName: String?,
    @SerializedName("region")
    var countryRegion: String?,
    @SerializedName("capital")
    var countryCapital: String?,
    @SerializedName("currency")
    var countryCurrency: String?,
    @SerializedName("language")
    var countryLanguage: String?,
    @SerializedName("flag")
    var imageUrl: String?
) {

}