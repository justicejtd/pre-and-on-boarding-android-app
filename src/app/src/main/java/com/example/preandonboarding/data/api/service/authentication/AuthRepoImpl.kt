package com.example.preandonboarding.data.api.service.authentication

import com.example.preandonboarding.utils.sharedPreference.AccessTokenSharedPref
import com.example.preandonboarding.utils.sharedPreference.UserSharedPref
import okhttp3.ResponseBody
import retrofit2.Response


/**
 * Manages authentication and sharedPreferences.
 */
class AuthRepoImpl(
    private val authService: AuthService,
    private val userSharedPref: UserSharedPref,
    private val accessTokenSharedPref: AccessTokenSharedPref
) : AuthRepo {

    override suspend fun login(
        email: String,
        password: String,
        deviceName: String
    ): Response<LoginResponse> = authService.login(email, password, deviceName)

    override suspend fun logout(): ResponseBody {
        userSharedPref.saveIsUserLoggedIn(false)
        return authService.logout()
    }

    override fun saveAccessToken(token: String) =
        accessTokenSharedPref.saveToken(token)

    override fun getAccessToken(): String = accessTokenSharedPref.getToken()

    override fun saveIsUserLoggedIn(isUserLoggedIn: Boolean) =
        userSharedPref.saveIsUserLoggedIn(isUserLoggedIn)

    override fun getIsUserLoggedIn(): Boolean =
        userSharedPref.getIsUserLoggedIn()
}