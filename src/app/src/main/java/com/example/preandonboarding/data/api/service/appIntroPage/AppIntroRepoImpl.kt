package com.example.preandonboarding.data.api.service.appIntroPage

import com.example.preandonboarding.data.model.appIntro.AppIntroConfig
import retrofit2.Response

class AppIntroRepoImpl(private val appIntroService: AppIntroService) : AppIntroRepo {
    override suspend fun getAppIntroPages(): Response<List<AppIntroConfig>> =
        appIntroService.getAppIntroConfigs()
}