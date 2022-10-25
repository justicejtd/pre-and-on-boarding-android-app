package com.example.preandonboarding.ui.theme

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.preandonboarding.data.api.service.theme.ThemeRepo
import com.example.preandonboarding.data.model.theme.ColorScheme
import com.example.preandonboarding.data.model.theme.Theme
import com.example.preandonboarding.data.model.user.User
import com.example.preandonboarding.utils.handlers.theme.ColorHandler
import com.example.preandonboarding.utils.handlers.theme.FontHandler
import com.example.preandonboarding.utils.handlers.theme.Logo
import kotlinx.coroutines.*

private const val DEFAULT_FONT = "Montserrat"
private const val ERROR_LOG_PRE_FIX = "Error"

class ThemeViewModel(private val themeRepo: ThemeRepo) : ViewModel() {
    var typography by mutableStateOf(FontHandler.getTypography(DEFAULT_FONT))
        private set
    var lightColorScheme by mutableStateOf(LightThemeColors)
        private set
    var darkColorScheme by mutableStateOf(DarkThemeColors)
        private set

    fun onLoadTheme() {
        viewModelScope.launch(Dispatchers.IO + CoroutineExceptionHandler { _, exception ->
            exception.printStackTrace()
            Log.e(ERROR_LOG_PRE_FIX, exception.message.toString())
            User.isUserLoggedIn = false
        }
        ) {
            // Get conversations
            val response = themeRepo.getTheme()

            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    // Update theme
                    response.body()?.let { it ->
                        setTheme(it)

                        // Delay to prevents the user from seeing the theme change
                        withContext(Dispatchers.IO) {
                            delay(500)
                        }
                    }
                } else {
                    Log.e(ERROR_LOG_PRE_FIX, response.body().toString())
                    User.isUserLoggedIn = false
                }
            }
        }
    }

    private fun setTheme(theme: Theme) {
        typography = FontHandler.getTypography(theme.font)
        setColorSchemes(theme.colorSchemes)
        Logo.setLogo(theme.logo)
    }

    private fun setColorSchemes(colorsSchemes: List<ColorScheme>) {
        colorsSchemes.forEach { colorScheme ->
            if (colorScheme.isLightColorScheme) {
                lightColorScheme = ColorHandler.createLightColorScheme(colorScheme)
            } else {
                darkColorScheme = ColorHandler.createDarkColorScheme(colorScheme)
            }
        }
    }
}