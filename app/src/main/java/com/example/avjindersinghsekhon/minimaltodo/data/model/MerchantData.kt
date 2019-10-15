package com.example.avjindersinghsekhon.minimaltodo.data.model


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MerchantData {

    @SerializedName("merchant_profile")
    @Expose
    var merchantProfile: MerchantProfile? = null
    @SerializedName("locale")
    @Expose
    var locale: String? = null

}
