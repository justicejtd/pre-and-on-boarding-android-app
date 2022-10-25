package com.example.preandonboarding.data.model.blockItem.message

import com.example.preandonboarding.utils.constants.ComposeKeys
import com.fasterxml.jackson.annotation.JsonProperty

data class Text(
    @JsonProperty("msgText")
    override var msgText: String,
    @JsonProperty("key")
    override val key: String = ComposeKeys.TEXT_BLOCK_ITEM,
    @JsonProperty("position")
    override val position: Int,
    @JsonProperty("nexBlockId")
    override val nexBlockId: Int = -1,
    @JsonProperty("isReply")
    override val isReply: Boolean = false
) : MessageBlockItem(position, nexBlockId, msgText, key)