package com.example.avjindersinghsekhon.minimaltodo.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class TokenRequest(
        @Expose
        @SerializedName("client_id") val clientId: String,
        @Expose
        @SerializedName("client_secret") val clientSecret: String,
        @Expose
        @SerializedName("code") val code: String,
        @Expose
        @SerializedName("grant_type") val grantType: String = "authorization_code"
)
