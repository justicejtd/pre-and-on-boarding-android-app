package com.example.preandonboarding.data.model.block.groupBlock

import com.example.preandonboarding.data.model.block.BaseBlock
import com.example.preandonboarding.data.model.blockItem.BlockItem
import com.example.preandonboarding.data.model.blockItem.group.GroupBlockItem
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

class GroupBlock @JsonCreator constructor(
    @JsonProperty("id")
    override val id: Int,
    @JsonProperty("isStartBlock")
    override val isStartBlock: Boolean = false,
    @JsonProperty("groupBlockItem")
    val groupBlockItem: GroupBlockItem,
) : BaseBlock(id, isStartBlock) {

    override fun getBlockItems(): List<BlockItem> {
        return listOf(groupBlockItem)
    }
}