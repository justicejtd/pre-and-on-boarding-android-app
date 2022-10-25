package com.example.preandonboarding.data.api.service.theme

import com.example.preandonboarding.data.api.service.authentication.ACCEPT_APPLICATION_JSON_TYPE
import com.example.preandonboarding.data.model.theme.Theme
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

private const val THEME_URL = "theme"

interface ThemeService {
    @Headers(ACCEPT_APPLICATION_JSON_TYPE)
    @GET(THEME_URL)
    suspend fun getTheme(): Response<Theme>
}