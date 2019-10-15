package com.example.avjindersinghsekhon.minimaltodo.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Event {

    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("transaction_id")
    @Expose
    var transactionId: String? = null
    @SerializedName("type")
    @Expose
    var type: String? = null
    @SerializedName("status")
    @Expose
    var status: String? = null
    @SerializedName("amount")
    @Expose
    var amount: Int? = null
    @SerializedName("timestamp")
    @Expose
    var timestamp: String? = null
    @SerializedName("fee_amount")
    @Expose
    var feeAmount: Int? = null
    @SerializedName("receipt_no")
    @Expose
    var receiptNo: String? = null

}
