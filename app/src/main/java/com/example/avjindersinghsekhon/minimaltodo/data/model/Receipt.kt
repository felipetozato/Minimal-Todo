package com.example.avjindersinghsekhon.minimaltodo.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Receipt {

    @SerializedName("transaction_data")
    @Expose
    var transactionData: TransactionData? = null
    @SerializedName("merchant_data")
    @Expose
    var merchantData: MerchantData? = null
    @SerializedName("card_application_data")
    @Expose
    var cardData: CardApplicationData? = null

}
