package com.example.preandonboarding.data.model.blockItem.wheelSpinner

import com.example.preandonboarding.data.model.blockItem.BlockItem
import com.example.preandonboarding.data.model.blockItem.NextBlockReference
import com.example.preandonboarding.data.model.user.User
import com.fasterxml.jackson.annotation.JsonProperty

data class WheelSpinner(
    @JsonProperty("users")
    val users: List<User>,
    @JsonProperty("msgText")
    override var msgText: String,
    @JsonProperty("key")
    override val key: String,
    @JsonProperty("nexBlockId")
    override val nexBlockId: Int = -1
) : BlockItem(msgText, key), NextBlockReference
