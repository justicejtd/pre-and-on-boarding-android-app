package com.example.preandonboarding.data.model.blockItem.buttonGroup

import com.example.preandonboarding.data.model.blockItem.BlockItem
import com.example.preandonboarding.data.model.blockItem.NextBlockReference
import com.example.preandonboarding.utils.constants.ComposeKeys
import com.fasterxml.jackson.annotation.JsonProperty

data class ButtonGroup(
    @JsonProperty("buttons")
    val buttons: List<Button>,
    @JsonProperty("msgText")
    override var msgText: String,
    @JsonProperty("key")
    override val key: String = ComposeKeys.BUTTON_GROUP_BLOCK_ITEM,
    @JsonProperty("nexBlockId")
    override val nexBlockId: Int = -1,
) : BlockItem(msgText, key), NextBlockReference