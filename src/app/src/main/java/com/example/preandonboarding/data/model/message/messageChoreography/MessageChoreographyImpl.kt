package com.example.preandonboarding.data.model.message.messageChoreography

import com.example.preandonboarding.data.model.message.messageConf.MessageConf


class MessageChoreographyImpl(private val messageConfig: MessageConf) : MessageChoreography {
    override fun calculateDelay(text: String, timing: Int) =
        messageConfig.calculateDelay(text, timing)
}