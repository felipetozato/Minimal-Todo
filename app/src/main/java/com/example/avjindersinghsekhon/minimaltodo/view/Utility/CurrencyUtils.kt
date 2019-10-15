package com.example.avjindersinghsekhon.minimaltodo.view.Utility

object CurrencyUtils {

    fun currencyCodeToDisplayableText(currency: String): String {
        return when(currency) {
            "BRL" -> "R$"
            else -> currency
        }
    }
}