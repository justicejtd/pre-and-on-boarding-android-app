package com.example.preandonboarding.data.model.blockItem.group

import com.example.preandonboarding.data.model.blockItem.BlockItem
import com.example.preandonboarding.data.model.blockItem.NextBlockReference
import com.fasterxml.jackson.annotation.JsonProperty

data class GroupBlockItem(
    @JsonProperty("msgText")
    override var msgText: String,
    @JsonProperty("key")
    override val key: String = "groupBlockItem",
    @JsonProperty("nexBlockId")
    override val nexBlockId: Int = -1,
    @JsonProperty("blockItems")
    val blockItems: List<BlockItem>,
) : BlockItem(msgText, key), NextBlockReference