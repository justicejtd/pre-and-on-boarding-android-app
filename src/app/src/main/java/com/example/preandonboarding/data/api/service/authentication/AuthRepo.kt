package com.example.preandonboarding.data.api.service.authentication

import okhttp3.ResponseBody
import retrofit2.Response


interface AuthRepo {

    /**
     * Calls auth service to authenticate user
     * @param email user email
     * @param password user password
     * @return Response<LoginResponse>
     */
    suspend fun login(email: String, password: String, deviceName: String): Response<LoginResponse>

    /**
     * Calls auth service to logout user
     * @return ResponseBody
     */
    suspend fun logout(): ResponseBody

    /**
     * Saves access token in shared preferences
     * @param token
     */
    fun saveAccessToken(token: String)

    /**
     * Get access token from shared preferences
     * @return String
     */
    fun getAccessToken(): String

    /**
     * Save user logged state in shared preferences.
     * @param isUserLoggedIn
     */
    fun saveIsUserLoggedIn(isUserLoggedIn: Boolean)

    /**
     * Get user logged state from shared preferences.
     * @return Boolean
     */
    fun getIsUserLoggedIn(): Boolean
}