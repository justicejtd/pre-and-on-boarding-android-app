package com.example.preandonboarding.data.api.service.module

import com.example.preandonboarding.data.api.service.authentication.ACCEPT_APPLICATION_JSON_TYPE
import com.example.preandonboarding.data.model.Module
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

private const val COMPANY_MODULES_URL = "company/modules"

interface ModuleService {

    @Headers(ACCEPT_APPLICATION_JSON_TYPE)
    @GET(COMPANY_MODULES_URL)
    suspend fun getModules(): Response<List<Module>>
}