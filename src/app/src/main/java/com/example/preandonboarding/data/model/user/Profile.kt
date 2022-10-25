package com.example.preandonboarding.data.model.user

import com.fasterxml.jackson.annotation.JsonProperty

data class Profile(
    @JsonProperty("description")
    val description: String,
    @JsonProperty("hobbies")
    val hobbies: List<String>,
    @JsonProperty("linkedIn")
    val linkedIn: String,
    @JsonProperty("phone")
    val phone: String,
    @JsonProperty("image")
    val image: String,
    @JsonProperty("role")
    val role: String,
)