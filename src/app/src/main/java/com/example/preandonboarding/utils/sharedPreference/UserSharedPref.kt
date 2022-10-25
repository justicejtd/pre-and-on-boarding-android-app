package com.example.preandonboarding.utils.sharedPreference

import android.content.Context
import com.example.preandonboarding.utils.handlers.sharedPreference.SharedPreference

private const val USER_STATE_SHARED_PREFERENCES_KEY = "user_status_SharedPreferences"
private const val IS_USER_LOGGED_IN_KEY = "access_token"

class UserSharedPref(override val context: Context): SharedPref {
    /**
     * Saves user login state to user state shared preferences.
     * @param isUserLoggedIn
     */
    fun saveIsUserLoggedIn(isUserLoggedIn: Boolean) {
        SharedPreference.saveData(
            USER_STATE_SHARED_PREFERENCES_KEY,
            IS_USER_LOGGED_IN_KEY,
            isUserLoggedIn.toString(),
            context
        )
    }

    /**
     * Get user state from user state shared preferences.
     * @return Boolean
     */
    fun getIsUserLoggedIn(): Boolean {
        return SharedPreference.getData(
            USER_STATE_SHARED_PREFERENCES_KEY,
            IS_USER_LOGGED_IN_KEY,
            context
        ).toBoolean()
    }
}
