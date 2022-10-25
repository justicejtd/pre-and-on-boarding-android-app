package com.example.preandonboarding.data.model.block

import com.example.preandonboarding.data.model.block.groupBlock.GroupBlock
import com.example.preandonboarding.data.model.block.button.ButtonBlock
import com.example.preandonboarding.data.model.block.input.InputBlock
import com.example.preandonboarding.data.model.block.message.MessageBlock
import com.example.preandonboarding.data.model.blockItem.BlockItem
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "blockType"
)
@JsonSubTypes(
    JsonSubTypes.Type(value = GroupBlock::class, name = "groupBlock"),
    JsonSubTypes.Type(value = MessageBlock::class, name = "messageBlock"),
    JsonSubTypes.Type(value = ButtonBlock::class, name = "buttonBlock"),
    JsonSubTypes.Type(value = InputBlock::class, name = "inputBlock")
)
abstract class BaseBlock(
    open val id: Int,
    open val isStartBlock: Boolean,
) {
    @JsonIgnore
    abstract fun getBlockItems(): List<BlockItem>
}