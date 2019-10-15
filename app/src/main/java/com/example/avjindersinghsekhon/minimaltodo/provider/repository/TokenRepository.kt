package com.example.avjindersinghsekhon.minimaltodo.provider.repository

import com.example.avjindersinghsekhon.minimaltodo.data.model.TokenRequest
import com.example.avjindersinghsekhon.minimaltodo.provider.local.SharedPreferenceSource
import com.example.avjindersinghsekhon.minimaltodo.provider.remote.WebApiClient

//Not used in the end
class TokenRepository {

    companion object {
        private const val CODE_KEY = "CODE_KEY"
    }

    //TODO @Inejct
    private val webApi = WebApiClient.apiInstance
    private val localStorage = SharedPreferenceSource()

    suspend fun getToken(): String? {
        localStorage.get("")
        val request = TokenRequest(
                clientId = "1234",
                clientSecret = "1234",
                code = localStorage.get(CODE_KEY),
                grantType = "authorization_code"
        )
        return webApi.getToken(request).token
    }

    fun saveCode(code: String) {
        localStorage.set(CODE_KEY, code)
    }
}