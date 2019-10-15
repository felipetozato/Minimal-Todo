package com.example.avjindersinghsekhon.minimaltodo.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Card {

    @SerializedName("last_4_digits")
    @Expose
    var last4Digits: String? = null
    @SerializedName("type")
    @Expose
    var type: String? = null
    @SerializedName("cardholder_name")
    @Expose
    var cardholderName: String? = null
    @SerializedName("expiry_month")
    @Expose
    var expiryMonth: String? = null
    @SerializedName("expiry_year")
    @Expose
    var expiryYear: String? = null
    @SerializedName("token")
    @Expose
    var token: String? = null

}
