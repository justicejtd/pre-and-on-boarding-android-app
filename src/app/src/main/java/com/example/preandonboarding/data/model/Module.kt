package com.example.preandonboarding.data.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

private const val MODULE_ID_FIELD_NAME = "id"
private const val MODULE_NAME_FIELD_NAME = "name"

/**
 * Holds module id and name.
 * @param id
 * @param name
 */
@JsonIgnoreProperties(ignoreUnknown = true)
data class Module(
    @JsonProperty(MODULE_ID_FIELD_NAME) val id: String,
    @JsonProperty(MODULE_NAME_FIELD_NAME) val name: String,
)