package com.example.preandonboarding.data.model.message.messageConf

/**
 * Message configuration based on string characters.
 */
class MessageConfChar : MessageConf {
    override fun calculateDelay(text: String, timing: Int): Long {
        return text.length * timing.toLong()
    }
}