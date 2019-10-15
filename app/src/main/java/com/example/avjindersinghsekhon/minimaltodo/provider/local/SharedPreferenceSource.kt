package com.example.avjindersinghsekhon.minimaltodo.provider.local

import android.content.Context.MODE_PRIVATE
import com.example.avjindersinghsekhon.minimaltodo.Analytics.AnalyticsApplication

class SharedPreferenceSource {

    companion object {
        private const val prefFile = "LOCAL_PREFS"
    }

    //TODO inject context with dagger
    private val sharedPref = AnalyticsApplication.appContext.getSharedPreferences(prefFile, MODE_PRIVATE)

    fun get(key: String) : String {
        return sharedPref.getString(key, "")!!
    }

    fun set(key: String, value: String) {
        sharedPref.edit()
                .putString(key, value)
                .apply()
    }
}