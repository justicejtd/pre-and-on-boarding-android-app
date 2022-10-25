package com.example.preandonboarding.data.model.blockItem

import com.example.preandonboarding.data.model.blockItem.group.GroupBlockItem
import com.example.preandonboarding.data.model.blockItem.buttonGroup.ButtonGroup
import com.example.preandonboarding.data.model.blockItem.input.GroupInput
import com.example.preandonboarding.data.model.blockItem.input.Input
import com.example.preandonboarding.data.model.blockItem.message.Media
import com.example.preandonboarding.data.model.blockItem.message.MessageBlockItem
import com.example.preandonboarding.data.model.blockItem.message.Text
import com.example.preandonboarding.data.model.blockItem.wheelSpinner.WheelSpinner
import com.example.preandonboarding.utils.constants.ComposeKeys
import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "blockItemType"
)
@JsonSubTypes(
    JsonSubTypes.Type(value = WheelSpinner::class, name = "wheelSpinner"),
    JsonSubTypes.Type(value = Text::class, name = "text"),
    JsonSubTypes.Type(value = Media::class, name = "media"),
    JsonSubTypes.Type(value = GroupBlockItem::class, name = "groupBlockItem"),
    JsonSubTypes.Type(value = MessageBlockItem::class, name = "messageBlockItem"),
    JsonSubTypes.Type(value = ButtonGroup::class, name = "buttonGroupBlockItem"),
    JsonSubTypes.Type(value = GroupInput::class, name = ComposeKeys.GROUP_INPUT_BLOCK_ITEM),
    JsonSubTypes.Type(value = Input::class, name = "inputBlockItem"),
)
abstract class BlockItem(open var msgText: String, open val key: String)