package com.example.avjindersinghsekhon.minimaltodo.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.sumup.merchant.Models.VatRate

class TransactionData {

    @SerializedName("transaction_code")
    @Expose
    var transactionCode: String? = null
    @SerializedName("amount")
    @Expose
    var amount: Double? = null
    @SerializedName("vat_amount")
    @Expose
    var vatAmount: Double? = null
    @SerializedName("tip_amount")
    @Expose
    var tipAmount: Double? = null
    @SerializedName("fee_amount")
    @Expose
    var feeAmount: Double? = null
    @SerializedName("currency")
    @Expose
    var currency: String? = null
    @SerializedName("timestamp")
    @Expose
    var timestamp: String? = null
    @SerializedName("status")
    @Expose
    var status: String? = null
    @SerializedName("payment_type")
    @Expose
    var paymentType: String? = null
    @SerializedName("entry_mode")
    @Expose
    var entryMode: String? = null
    @SerializedName("verification_method")
    @Expose
    var verificationMethod: String? = null
    @SerializedName("card")
    @Expose
    var card: Card? = null
    @SerializedName("installments_count")
    @Expose
    var installmentsCount: Int? = null
    @SerializedName("customer_email")
    @Expose
    var customerEmail: String? = null
    @SerializedName("products")
    @Expose
    var products: List<Product>? = null
    @SerializedName("vat_rates")
    @Expose
    var vatRates: List<VatRate>? = null
    @SerializedName("location")
    @Expose
    var location: Location? = null
    @SerializedName("events")
    @Expose
    var events: List<Event>? = null
    @SerializedName("receipt_no")
    @Expose
    var receiptNo: String? = null

}
