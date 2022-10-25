package com.example.preandonboarding.data.model.blockItem.message

import com.example.preandonboarding.data.model.blockItem.BlockItem
import com.example.preandonboarding.data.model.blockItem.NextBlockReference
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "messageBlockItemType"
)
@JsonSubTypes(
    JsonSubTypes.Type(value = Text::class, name = "text"),
    JsonSubTypes.Type(value = Media::class, name = "media")
)
abstract class MessageBlockItem(
    open val position: Int,
    override val nexBlockId: Int,
    override var msgText: String,
    @JsonIgnore
    override val key: String,
    @JsonIgnore
    open val isReply:Boolean = false,
) : BlockItem(msgText, key), NextBlockReference