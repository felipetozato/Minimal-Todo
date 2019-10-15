package com.example.avjindersinghsekhon.minimaltodo.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MerchantProfile {

    @SerializedName("merchant_code")
    @Expose
    var merchantCode: String? = null
    @SerializedName("business_name")
    @Expose
    var businessName: String? = null
    @SerializedName("email")
    @Expose
    var email: String? = null
    @SerializedName("address")
    @Expose
    var address: Address? = null
}
