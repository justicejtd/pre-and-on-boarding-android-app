package com.example.preandonboarding.utils.handlers.sharedPreference

import android.content.Context
import android.content.Context.MODE_PRIVATE

private const val TOKEN_SHARED_PREFERENCES_KEY = "token_SharedPreferences"
private const val ACCESS_TOKEN_KEY = "access_token"

/**
 * Handles shared preferences
 */
object SharedPreference {
    fun saveData(sharedPrefKey: String, dataKey: String, data: String, context: Context) {
        val sharedPref = context.getSharedPreferences(sharedPrefKey, MODE_PRIVATE).edit()
        sharedPref.putString(dataKey, data)
        sharedPref.apply()
    }

    fun getData(sharedPrefKey: String, dataKey: String, context: Context): String? {
        val sharedPref =
            context.getSharedPreferences(sharedPrefKey, MODE_PRIVATE)
        return sharedPref.getString(dataKey, "Value not found")
    }
}

class AccessTokenSharedPref() {
    /**
     * Saves token into token shared preferences.
     * @param accessToken
     */
    fun saveToken(accessToken: String, context: Context) {
        SharedPreference.saveData(TOKEN_SHARED_PREFERENCES_KEY, ACCESS_TOKEN_KEY, accessToken, context)
    }

    /**
     * Get token from token shared preferences.
     * @return String
     */
    fun getToken(context: Context): String {
        return SharedPreference.getData(TOKEN_SHARED_PREFERENCES_KEY, ACCESS_TOKEN_KEY, context) ?: ""
    }
}