package com.example.avjindersinghsekhon.minimaltodo.provider.remote

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WebApiClient {

    //TODO. Instead of receiptSingleton, use dagger to resolve this as well.
    //and provide as a receiptSingleton.
    companion object {

        private var receiptSingleton: ReceiptsApi? = null
        val receiptsInstance: ReceiptsApi get() {
            if (receiptSingleton == null) {
                receiptSingleton = buildClientReceipt()
            }
            return receiptSingleton!!
        }

        private var apiSingleton: WebAPI? = null
        val apiInstance: WebAPI get() {
            if (apiSingleton == null) {
                apiSingleton = buildClient()
            }
            return apiSingleton!!
        }

        private fun buildClientReceipt() : ReceiptsApi {
            val retrofit = Retrofit.Builder()
                    .baseUrl("https://receipts-ng.sumup.com/")
                    .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                    .build()
            return retrofit.create(ReceiptsApi::class.java)
        }

        private fun buildClient() : WebAPI {
            val retrofit = Retrofit.Builder()
                    .baseUrl("https://api.sumup.com/")
                    .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                    .build()
            return retrofit.create(WebAPI::class.java)
        }
    }
}