package com.example.preandonboarding.data.model.theme

import com.fasterxml.jackson.annotation.JsonProperty

data class Theme(
    @JsonProperty("font")
    val font: String,
    @JsonProperty("colorSchemes")
    val colorSchemes: List<ColorScheme>,
    @JsonProperty("logo")
    val logo: String?
)
