package com.example.preandonboarding.data.model.message.messageConf

import org.junit.Assert.*

import org.junit.Test


class MessageConfCharTest {

    /**
     * Should check if delay time is equal to the number of characters times the time per character.
     */
    @Test
    fun calculateDelayTime_shouldCalculateTheDelayBasedOnNrOfCharAndDelayPerChar() {
        val delayPerChar = 10
        val text = "This is certain amount of characters"
        val expected: Long = 360
        val messageConfChar = MessageConfChar()

        val actual = messageConfChar.calculateDelay(text, delayPerChar)

        assertEquals(
            "Should check if delay time is equal to the number of characters times the time per character",
            expected,
            actual
        )
    }
}