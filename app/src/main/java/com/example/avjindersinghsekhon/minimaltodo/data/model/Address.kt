package com.example.avjindersinghsekhon.minimaltodo.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Address {

    @SerializedName("address_line1")
    @Expose
    var addressLine1: String? = null
    @SerializedName("city")
    @Expose
    var city: String? = null
    @SerializedName("country")
    @Expose
    var country: String? = null
    @SerializedName("country_en_name")
    @Expose
    var countryEnName: String? = null
    @SerializedName("country_native_name")
    @Expose
    var countryNativeName: String? = null
    @SerializedName("post_code")
    @Expose
    var postCode: String? = null
    @SerializedName("region_name")
    @Expose
    var regisonName: String? = null

}
