package com.example.avjindersinghsekhon.minimaltodo.provider.repository

import com.example.avjindersinghsekhon.minimaltodo.data.model.Receipt
import com.example.avjindersinghsekhon.minimaltodo.provider.remote.WebApiClient

class ReceiptRepository {

    //TODO @Inejct
    private val webApi = WebApiClient.receiptsInstance

    suspend fun getReceipt(id: String): Receipt {

        return webApi.getReceipt(id)
    }
}