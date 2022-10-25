package com.example.preandonboarding.data.api.service.authentication

import com.fasterxml.jackson.annotation.JsonProperty

private const val ACCESS_TOKEN_FIELD_NAME = "access_token"
private const val TOKEN_TYPE_FIELD_NAME = "token_type"

/**
 * Data class for holding login response access token and token type.
 * @param token
 * @param tokenType
 */
data class LoginResponse(
    @JsonProperty(ACCESS_TOKEN_FIELD_NAME)
    val token: String,
    @JsonProperty(TOKEN_TYPE_FIELD_NAME)
    val tokenType: String
)