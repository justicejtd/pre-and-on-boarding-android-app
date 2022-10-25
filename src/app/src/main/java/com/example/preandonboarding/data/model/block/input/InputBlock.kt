package com.example.preandonboarding.data.model.block.input

import com.example.preandonboarding.data.model.block.BaseBlock
import com.example.preandonboarding.data.model.blockItem.BlockItem
import com.example.preandonboarding.data.model.blockItem.input.Input
import com.fasterxml.jackson.annotation.JsonProperty

class InputBlock(
    @JsonProperty("id")
    override val id: Int,
    @JsonProperty("isStartBlock")
    override val isStartBlock: Boolean = false,
    @JsonProperty("input")
    val input: Input,
) : BaseBlock(id, isStartBlock) {

    override fun getBlockItems(): List<BlockItem> {
        return listOf(input)
    }
}