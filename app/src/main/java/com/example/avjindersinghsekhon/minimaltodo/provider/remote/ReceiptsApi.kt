package com.example.avjindersinghsekhon.minimaltodo.provider.remote

import com.example.avjindersinghsekhon.minimaltodo.data.model.Receipt
import com.example.avjindersinghsekhon.minimaltodo.BuildConfig
import retrofit2.http.GET
import retrofit2.http.Path

interface ReceiptsApi {

    companion object {
        private const val merchantId = BuildConfig.MERCHANT_ID
    }

    @GET("v0.1/receipts/{transactionId}?mid=$merchantId")
    suspend fun getReceipt(@Path("transactionId") id: String) : Receipt
}