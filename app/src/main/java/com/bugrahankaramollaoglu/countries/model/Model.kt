package com.bugrahankaramollaoglu.countries.model


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
    var countryName: String?,
    var countryRegion: String?,
    var countryCapital: String?,
    var countryCurrency: String?,
    var countryLanguage: String?,
    var imageUrl: String?
) {

}