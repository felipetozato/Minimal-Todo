package com.example.avjindersinghsekhon.minimaltodo.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CardApplicationData {

    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("aid")
    @Expose
    var aid: String? = null
}
