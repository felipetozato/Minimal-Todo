package com.example.avjindersinghsekhon.minimaltodo.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class TokenInfo(
        @Expose
        @SerializedName("access_token") val token: String? = null,
        @Expose
        @SerializedName("token_type") val type: String? = null,
        @Expose
        @SerializedName("refresh_token") val refreshToken: String? = null
)
