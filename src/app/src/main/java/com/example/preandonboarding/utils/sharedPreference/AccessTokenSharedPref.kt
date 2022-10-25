package com.example.preandonboarding.utils.sharedPreference

import android.content.Context
import com.example.preandonboarding.data.model.Token
import com.example.preandonboarding.utils.handlers.sharedPreference.SharedPreference

private const val TOKEN_SHARED_PREFERENCES_KEY = "token_SharedPreferences"
private const val ACCESS_TOKEN_KEY = "access_token"

class AccessTokenSharedPref(override val context: Context) : SharedPref {
    /**
     * Saves token into token shared preferences.
     * @param token
     */
    fun saveToken(token: String) {
        // Set token globally
        saveTokenGlobally(token)

        SharedPreference.saveData(TOKEN_SHARED_PREFERENCES_KEY, ACCESS_TOKEN_KEY, token, context)
    }

    /**
     * Get token from token shared preferences.
     * @return String
     */
    fun getToken(): String {
        return SharedPreference.getData(TOKEN_SHARED_PREFERENCES_KEY, ACCESS_TOKEN_KEY, context)
            ?: ""
    }

    private fun saveTokenGlobally(token: String) {
        Token.accessToken = token
    }
}