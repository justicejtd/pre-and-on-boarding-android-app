package com.example.preandonboarding.data.model.message.messageChoreography

import com.example.preandonboarding.data.model.message.messageConf.MessageConf
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MessageChoreographyTest {

    /**
     * Should call calculateDelayTime on MessageChoreography
     */
    @Test
    fun calculateDelayTime_shouldCallCalculateDelayTime() {
        val delayPerChar = 10
        val text = "This is certain amount of characters"
        val messageConfChar = mock(MessageConf::class.java)
        val messageChoreography = MessageChoreographyImpl(messageConfChar)

        messageChoreography.calculateDelay(text, delayPerChar)

        verify(messageConfChar).calculateDelay(text, delayPerChar)
    }
}