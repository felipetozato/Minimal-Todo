package com.example.avjindersinghsekhon.minimaltodo.provider.remote

import com.example.avjindersinghsekhon.minimaltodo.data.model.TokenInfo
import com.example.avjindersinghsekhon.minimaltodo.data.model.TokenRequest
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

//Not used in the end
interface WebAPI {

    @Headers("Content-Type: application/x-www-form-urlencoded")
    @POST("/token")
    suspend fun getToken(@Body body: TokenRequest) : TokenInfo
}