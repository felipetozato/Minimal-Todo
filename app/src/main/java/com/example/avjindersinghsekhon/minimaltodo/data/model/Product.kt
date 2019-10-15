package com.example.avjindersinghsekhon.minimaltodo.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Product {

    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("price")
    @Expose
    var price: Double? = null
    @SerializedName("quantity")
    @Expose
    var quantity: Int? = null
    @SerializedName("total_price")
    @Expose
    var totalPrice: Double? = null

}
