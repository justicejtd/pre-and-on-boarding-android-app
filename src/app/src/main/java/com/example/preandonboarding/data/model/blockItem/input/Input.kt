package com.example.preandonboarding.data.model.blockItem.input

import com.example.preandonboarding.data.model.blockItem.BlockItem
import com.example.preandonboarding.data.model.blockItem.NextBlockReference
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty

data class Input(
    @JsonProperty("replyText")
    @JsonIgnore
    var replyText: String? = "",
    @JsonProperty("type")
    val type: String,
    @JsonProperty("msgText")
    override var msgText: String,
    @JsonProperty("key")
    override val key: String,
    @JsonProperty("nexBlockId")
    override val nexBlockId: Int = -1
) : BlockItem(msgText, key), NextBlockReference
