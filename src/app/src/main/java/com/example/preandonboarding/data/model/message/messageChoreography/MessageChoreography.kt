package com.example.preandonboarding.data.model.message.messageChoreography


interface MessageChoreography {
    /**
     * Calls calculateDelay on MessageConf.calculateDelay.
     * @param text  The actual message.
     * @param timing The timing between characters.
     */
    fun calculateDelay(text: String, timing: Int): Long
}