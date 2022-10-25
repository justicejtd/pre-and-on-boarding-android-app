package com.example.preandonboarding.data.api.service.theme

import com.example.preandonboarding.data.model.theme.Theme
import retrofit2.Response

interface ThemeRepo {
    /**
     * Returns app theme
     * @return Response<Theme>
     */
    suspend fun getTheme(): Response<Theme>
}