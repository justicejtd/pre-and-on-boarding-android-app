package com.example.preandonboarding.data.api.service.theme

import com.example.preandonboarding.data.model.theme.Theme
import retrofit2.Response

class ThemeRepoImpl(private val themeService: ThemeService) : ThemeRepo {
    override suspend fun getTheme(): Response<Theme> = themeService.getTheme()
}
