package com.example.preandonboarding.utils.handlers.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import com.example.preandonboarding.data.model.theme.ColorScheme

object ColorHandler {
    fun createLightColorScheme(colorScheme: ColorScheme): androidx.compose.material3.ColorScheme {
        return lightColorScheme(
            primary = Color(android.graphics.Color.parseColor(colorScheme.primary)),
            onPrimary = Color(android.graphics.Color.parseColor(colorScheme.onPrimary)),
            primaryContainer = Color(android.graphics.Color.parseColor(colorScheme.primaryContainer)),
            onPrimaryContainer = Color(android.graphics.Color.parseColor(colorScheme.onPrimaryContainer)),
            secondary = Color(android.graphics.Color.parseColor(colorScheme.secondary)),
            onSecondary = Color(android.graphics.Color.parseColor(colorScheme.onSecondary)),
            secondaryContainer = Color(android.graphics.Color.parseColor(colorScheme.secondaryContainer)),
            onSecondaryContainer = Color(android.graphics.Color.parseColor(colorScheme.onSecondaryContainer)),
            tertiary = Color(android.graphics.Color.parseColor(colorScheme.tertiary)),
            onTertiary = Color(android.graphics.Color.parseColor(colorScheme.onTertiary)),
            tertiaryContainer = Color(android.graphics.Color.parseColor(colorScheme.tertiaryContainer)),
            onTertiaryContainer = Color(android.graphics.Color.parseColor(colorScheme.onTertiaryContainer)),
            error = Color(android.graphics.Color.parseColor(colorScheme.error)),
            errorContainer = Color(android.graphics.Color.parseColor(colorScheme.errorContainer)),
            onError = Color(android.graphics.Color.parseColor(colorScheme.onError)),
            onErrorContainer = Color(android.graphics.Color.parseColor(colorScheme.onErrorContainer)),
            background = Color(android.graphics.Color.parseColor(colorScheme.background)),
            onBackground = Color(android.graphics.Color.parseColor(colorScheme.onBackground)),
            surface = Color(android.graphics.Color.parseColor(colorScheme.surface)),
            onSurface = Color(android.graphics.Color.parseColor(colorScheme.onSurface)),
            surfaceVariant = Color(android.graphics.Color.parseColor(colorScheme.surfaceVariant)),
            onSurfaceVariant = Color(android.graphics.Color.parseColor(colorScheme.onSurfaceVariant)),
            outline = Color(android.graphics.Color.parseColor(colorScheme.outline)),
            inverseOnSurface = Color(android.graphics.Color.parseColor(colorScheme.inverseOnSurface)),
            inverseSurface = Color(android.graphics.Color.parseColor(colorScheme.inverseOnSurface)),
            inversePrimary = Color(android.graphics.Color.parseColor(colorScheme.inversePrimary)),
        )
    }

    fun createDarkColorScheme(colorScheme: ColorScheme): androidx.compose.material3.ColorScheme {
        return darkColorScheme(
            primary = Color(android.graphics.Color.parseColor(colorScheme.primary)),
            onPrimary = Color(android.graphics.Color.parseColor(colorScheme.onPrimary)),
            primaryContainer = Color(android.graphics.Color.parseColor(colorScheme.primaryContainer)),
            onPrimaryContainer = Color(android.graphics.Color.parseColor(colorScheme.onPrimaryContainer)),
            secondary = Color(android.graphics.Color.parseColor(colorScheme.secondary)),
            onSecondary = Color(android.graphics.Color.parseColor(colorScheme.onSecondary)),
            secondaryContainer = Color(android.graphics.Color.parseColor(colorScheme.secondaryContainer)),
            onSecondaryContainer = Color(android.graphics.Color.parseColor(colorScheme.onSecondaryContainer)),
            tertiary = Color(android.graphics.Color.parseColor(colorScheme.tertiary)),
            onTertiary = Color(android.graphics.Color.parseColor(colorScheme.onTertiary)),
            tertiaryContainer = Color(android.graphics.Color.parseColor(colorScheme.tertiaryContainer)),
            onTertiaryContainer = Color(android.graphics.Color.parseColor(colorScheme.onTertiaryContainer)),
            error = Color(android.graphics.Color.parseColor(colorScheme.error)),
            errorContainer = Color(android.graphics.Color.parseColor(colorScheme.errorContainer)),
            onError = Color(android.graphics.Color.parseColor(colorScheme.onError)),
            onErrorContainer = Color(android.graphics.Color.parseColor(colorScheme.onErrorContainer)),
            background = Color(android.graphics.Color.parseColor(colorScheme.background)),
            onBackground = Color(android.graphics.Color.parseColor(colorScheme.onBackground)),
            surface = Color(android.graphics.Color.parseColor(colorScheme.surface)),
            onSurface = Color(android.graphics.Color.parseColor(colorScheme.onSurface)),
            surfaceVariant = Color(android.graphics.Color.parseColor(colorScheme.surfaceVariant)),
            onSurfaceVariant = Color(android.graphics.Color.parseColor(colorScheme.onSurfaceVariant)),
            outline = Color(android.graphics.Color.parseColor(colorScheme.outline)),
            inverseOnSurface = Color(android.graphics.Color.parseColor(colorScheme.inverseOnSurface)),
            inverseSurface = Color(android.graphics.Color.parseColor(colorScheme.inverseOnSurface)),
            inversePrimary = Color(android.graphics.Color.parseColor(colorScheme.inversePrimary)),
        )
    }
}