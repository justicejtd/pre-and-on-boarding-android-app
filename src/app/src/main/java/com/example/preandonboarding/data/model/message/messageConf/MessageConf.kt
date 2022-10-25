package com.example.preandonboarding.data.model.message.messageConf

/**
 * Configuration on how a message should be shown.
 */
interface MessageConf {
    /**
     * Calculates the time delay based on text length and timing per character.
     * @param text  The actual message
     * @param timing The timing between characters.
     */
    fun calculateDelay(text: String, timing: Int): Long
}