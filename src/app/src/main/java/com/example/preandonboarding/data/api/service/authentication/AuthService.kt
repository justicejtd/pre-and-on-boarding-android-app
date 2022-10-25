package com.example.preandonboarding.data.api.service.authentication

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.*

/**
 * Used for Http headers application/json accept type.
 */
const val ACCEPT_APPLICATION_JSON_TYPE = "Accept: application/json"
private const val USER_LOGIN_URL = "users/login"
private const val EMAIL_FIELD_NAME = "email"
private const val PASSWORD_FIELD_NAME = "password"
private const val DEVICE_NAME_FIELD_NAME = "device_name"
private const val LOGOUT_URL = "users/logout"

interface AuthService {

    @Headers(ACCEPT_APPLICATION_JSON_TYPE)
    @FormUrlEncoded
    @POST(USER_LOGIN_URL)
    suspend fun login(
        @Field(EMAIL_FIELD_NAME) email: String,
        @Field(PASSWORD_FIELD_NAME) password: String,
        @Field(DEVICE_NAME_FIELD_NAME) device_name: String
    ): Response<LoginResponse>

    /**
     * Request user logout on endpoint users/logout.
     * @return ResponseBody
     */
    @Headers(ACCEPT_APPLICATION_JSON_TYPE)
    @GET(LOGOUT_URL)
    suspend fun logout(): ResponseBody
}