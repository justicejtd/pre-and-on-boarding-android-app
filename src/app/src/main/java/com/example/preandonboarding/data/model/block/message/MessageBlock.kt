package com.example.preandonboarding.data.model.block.message

import com.example.preandonboarding.data.model.block.BaseBlock
import com.example.preandonboarding.data.model.blockItem.BlockItem
import com.example.preandonboarding.data.model.blockItem.message.MessageBlockItem
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

class MessageBlock @JsonCreator constructor(
    @JsonProperty("id")
    override val id: Int,
    @JsonProperty("isStartBlock")
    override val isStartBlock: Boolean = false,
    @JsonProperty("messageBlockItems")
    val messageBlockItems: List<MessageBlockItem>
) : BaseBlock(id, isStartBlock) {

    override fun getBlockItems(): List<BlockItem> {
        return messageBlockItems
    }
}