package com.example.preandonboarding.data.api.service.appIntroPage

import com.example.preandonboarding.data.api.service.authentication.ACCEPT_APPLICATION_JSON_TYPE
import com.example.preandonboarding.data.model.appIntro.AppIntroConfig
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

private const val APP_INTRO_PAGE_CONFIGS_URL = "appIntro/configs"

interface AppIntroService {

    @Headers(ACCEPT_APPLICATION_JSON_TYPE)
    @GET(APP_INTRO_PAGE_CONFIGS_URL)
    suspend fun getAppIntroConfigs(): Response<List<AppIntroConfig>>
}