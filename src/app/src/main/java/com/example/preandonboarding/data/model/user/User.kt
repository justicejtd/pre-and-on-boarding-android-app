package com.example.preandonboarding.data.model.user

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty

class User(
    @JsonProperty("name")
    val name: String,
    @JsonProperty("email")
    val email: String,
    @JsonProperty("profile")
    val profile: Profile
) {
    companion object {
        var isUserLoggedIn by mutableStateOf(false)
    }
}