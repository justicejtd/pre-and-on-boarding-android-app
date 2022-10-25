package com.example.preandonboarding.data.model.blockItem.buttonGroup

import com.example.preandonboarding.data.model.blockItem.NextBlockReference
import com.fasterxml.jackson.annotation.JsonProperty

class Button(
    @JsonProperty("label")
    val label: String,
    @JsonProperty("url")
    val url: String = "",
    @JsonProperty("position")
    val position: Int,
    @JsonProperty("nexBlockId3")
    override val nexBlockId: Int = -1
): NextBlockReference
