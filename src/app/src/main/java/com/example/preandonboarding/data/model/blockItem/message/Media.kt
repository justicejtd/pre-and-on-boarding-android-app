package com.example.preandonboarding.data.model.blockItem.message

import com.example.preandonboarding.utils.constants.ComposeKeys
import com.fasterxml.jackson.annotation.JsonProperty

data class Media(
    @JsonProperty(typeArg)
    val type: String,
    @JsonProperty(urlArg)
    val url: String,
    @JsonProperty(positionArg)
    override val position: Int,
    @JsonProperty(nextBlockIdArg)
    override val nexBlockId: Int = -1,
    @JsonProperty(msgTextArg)
    override var msgText: String,
    @JsonProperty(keyArg)
    override val key: String = ComposeKeys.MEDIA_BLOCK_ITEM,
    @JsonProperty(isReplyArg)
    override val isReply: Boolean = false,
) : MessageBlockItem(position, nexBlockId, msgText, key) {
    companion object {
        const val typeArg = "type"
        const val urlArg = "url"
        const val positionArg = "position"
        const val nextBlockIdArg = "nexBlockId"
        const val msgTextArg = "msgText"
        const val keyArg = "key"
        const val isReplyArg = "isReply"
    }
}