package com.example.preandonboarding.data.model.conversation

import com.example.preandonboarding.data.model.block.BaseBlock
import com.example.preandonboarding.data.model.user.User
import com.fasterxml.jackson.annotation.JsonProperty

data class Conversation (
    @JsonProperty("id")
    val id: Int,
    @JsonProperty("title")
    val title: String,
    @JsonProperty("user")
    val user: User,
    @JsonProperty("blocks")
    val blocks: List<BaseBlock>
)
