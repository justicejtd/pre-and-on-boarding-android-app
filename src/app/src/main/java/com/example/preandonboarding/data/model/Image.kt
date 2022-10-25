package com.example.preandonboarding.data.model

import com.fasterxml.jackson.annotation.JsonProperty

class Image(
    @JsonProperty("url")
    val url: String,
    @JsonProperty("contentDescription")
    val contentDescription: String
)