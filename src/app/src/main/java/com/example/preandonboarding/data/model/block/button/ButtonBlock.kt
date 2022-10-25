package com.example.preandonboarding.data.model.block.button

import com.example.preandonboarding.data.model.block.BaseBlock
import com.example.preandonboarding.data.model.blockItem.BlockItem
import com.example.preandonboarding.data.model.blockItem.buttonGroup.ButtonGroup
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

class ButtonBlock @JsonCreator constructor(
    @JsonProperty("id")
    override val id: Int,
    @JsonProperty("isStartBlock")
    override val isStartBlock: Boolean = false,
    @JsonProperty("buttonGroup")
    val buttonGroup: ButtonGroup,
) : BaseBlock(id, isStartBlock) {

    override fun getBlockItems(): List<BlockItem> {
        return listOf(buttonGroup)
    }
}