package com.example.preandonboarding.data.model.theme

import com.fasterxml.jackson.annotation.JsonProperty

data class ColorScheme(
    @JsonProperty("isLightColorScheme")
    val isLightColorScheme: Boolean,
    @JsonProperty("primary")
    val primary: String,
    @JsonProperty("onPrimary")
    val onPrimary: String,
    @JsonProperty("primaryContainer")
    val primaryContainer: String,
    @JsonProperty("onPrimaryContainer")
    val onPrimaryContainer: String,
    @JsonProperty("secondary")
    val secondary: String,
    @JsonProperty("onSecondary")
    val onSecondary: String,
    @JsonProperty("secondaryContainer")
    val secondaryContainer: String,
    @JsonProperty("onSecondaryContainer")
    val onSecondaryContainer: String,
    @JsonProperty("tertiary")
    val tertiary: String,
    @JsonProperty("onTertiary")
    val onTertiary: String,
    @JsonProperty("tertiaryContainer")
    val tertiaryContainer: String,
    @JsonProperty("onTertiaryContainer")
    val onTertiaryContainer: String,
    @JsonProperty("error")
    val error: String,
    @JsonProperty("errorContainer")
    val errorContainer: String,
    @JsonProperty("onError")
    val onError: String,
    @JsonProperty("onErrorContainer")
    val onErrorContainer: String,
    @JsonProperty("background")
    val background: String,
    @JsonProperty("onBackground")
    val onBackground: String,
    @JsonProperty("surface")
    val surface: String,
    @JsonProperty("onSurface")
    val onSurface: String,
    @JsonProperty("surfaceVariant")
    val surfaceVariant: String,
    @JsonProperty("onSurfaceVariant")
    val onSurfaceVariant: String,
    @JsonProperty("outline")
    val outline: String,
    @JsonProperty("inverseOnSurface")
    val inverseOnSurface: String,
    @JsonProperty("inverseSurface")
    val inverseSurface: String,
    @JsonProperty("inversePrimary")
    val inversePrimary: String,
)

