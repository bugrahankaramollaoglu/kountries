package com.bugrahankaramollaoglu.countries.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
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

/* serializedName, json apiden veri cekerken
* apideki key'lerle seninkiler ayni degilse (ki genelde farklı
* kullanilir) keyleri baglamak icin kullanılır. serailzedname icine
* yazdigin api keyiyle birebir ayni olmalidir */

@Entity(tableName = "country")
data class Country(
    @ColumnInfo(name = "name")
    @SerializedName("name")
    var countryName: String?,
    @ColumnInfo(name = "region")
    @SerializedName("region")
    var countryRegion: String?,
    @ColumnInfo(name = "capital")
    @SerializedName("capital")
    var countryCapital: String?,
    @ColumnInfo(name = "currency")
    @SerializedName("currency")
    var countryCurrency: String?,
    @ColumnInfo(name = "language")
    @SerializedName("language")
    var countryLanguage: String?,
    @ColumnInfo(name = "flag")
    @SerializedName("flag")
    val imageUrl: String?,

    @PrimaryKey(autoGenerate = true)
    var uuid: Int = 0
)

/* room teknolojisini kullanirken 3 component yaratiyosun
*
* Database: veritabanını simgeliyor
* Entity: veritabanındaki table yapısını simgeliyor
* DAO (database access object): db'ye ulaşırken kullandıgın metotları simgeliyor
*
* */