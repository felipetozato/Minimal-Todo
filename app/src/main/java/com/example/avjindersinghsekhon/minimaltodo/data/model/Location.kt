package com.example.avjindersinghsekhon.minimaltodo.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Location {

    @SerializedName("lat")
    @Expose
    var lat: Double? = null
    @SerializedName("lon")
    @Expose
    var lon: Double? = null
    @SerializedName("horizontal_accuracy")
    @Expose
    var horizontalAccuracy: Double? = null

}
