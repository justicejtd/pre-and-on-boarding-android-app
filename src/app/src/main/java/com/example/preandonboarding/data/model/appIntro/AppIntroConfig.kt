package com.example.preandonboarding.data.model.appIntro

import com.example.preandonboarding.data.model.Image
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Data class to hold the configuration/content of the app intro page.
 * @param title
 * @param description
 * @param image
 */
class AppIntroConfig(
    @JsonProperty("title")
    val title: String,
    @JsonProperty("description")
    val description: String,
    @JsonProperty("image")
    val image: Image,
    @JsonProperty("color")
    val color: String
)