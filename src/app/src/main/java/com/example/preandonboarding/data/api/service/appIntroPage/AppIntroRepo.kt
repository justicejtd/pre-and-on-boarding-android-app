package com.example.preandonboarding.data.api.service.appIntroPage

import com.example.preandonboarding.data.model.appIntro.AppIntroConfig
import retrofit2.Response

interface AppIntroRepo {
    /**
     * Returns a response with list of App introduction pages.
     * @return Response<List<AppIntroConfig>>
     */
    suspend fun getAppIntroPages(): Response<List<AppIntroConfig>>
}