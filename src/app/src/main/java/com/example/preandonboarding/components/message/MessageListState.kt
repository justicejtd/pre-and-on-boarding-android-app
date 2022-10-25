package com.example.preandonboarding.components.message

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.*
import com.example.preandonboarding.data.model.blockItem.BlockItem
import com.example.preandonboarding.data.model.blockItem.message.MessageBlockItem
import com.example.preandonboarding.data.model.message.messageChoreography.MessageChoreographyImpl
import com.example.preandonboarding.data.model.message.messageConf.MessageConfChar
import kotlinx.coroutines.*


/**
 * Handles the states of the message list
 * @param coroutineScope used
 */
class MessageListState(
    val coroutineScope: CoroutineScope,
    val lazyListState: LazyListState,
    val onNextBlock: (Int) -> Unit,
    val conversationMessages: MutableState<List<BlockItem>>,
    var isTypingLottieShown: MutableState<Boolean>
) {

    /**
     * Keeps track if the lottie typing animation should be shown or not
     */
    fun runFlow(blockItems: List<BlockItem>) {
        coroutineScope.launch {
            blockItems.forEach {
                withContext(Dispatchers.Main) {
                    addBlockItem(it)
                    setTypingAnimation(true)
                }

                // Scroll to the current message
                animateScrollToCurrentMessage()

                // Remove typing if it is the last item
                if (blockItems.last() == it && it !is MessageBlockItem) {

                    withContext(Dispatchers.Main) {
                        setTypingAnimation(false)
                    }
                } else {
                    // Set delay between block items
                    delayMessageFlow(it.msgText)

                    withContext(Dispatchers.Main) {
                        setTypingAnimation(false)
                    }
                }

                withContext(Dispatchers.Main) {
                    if (blockItems.last() == it && it is MessageBlockItem) {
                        onNextBlock(it.nexBlockId)
                    }
                }
            }
        }
    }

    private suspend fun delayMessageFlow(msgText: String) {
        val messageChoreography = MessageChoreographyImpl(MessageConfChar())
        // Set delay between block items
        delay(messageChoreography.calculateDelay(msgText, 25))
    }

    private fun setTypingAnimation(isShown: Boolean) {
        isTypingLottieShown.value = isShown
    }

    fun addBlockItem(blockItem: BlockItem) {
        conversationMessages.value = conversationMessages.value + listOf(blockItem)
    }

    fun removeBlockItem(blockItem: BlockItem) {
        conversationMessages.value =
            conversationMessages.value.toMutableList().also { it.remove(blockItem) }
    }

    private fun animateScrollToCurrentMessage() {
        coroutineScope.launch {
            lazyListState.animateScrollToItem(index = conversationMessages.value.size)
        }
    }
}

@Composable
fun rememberMessageListState(
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    lazyListState: LazyListState = rememberLazyListState(),
    onNextBlock: (Int) -> Unit,
    conversationMessages: MutableState<List<BlockItem>> = remember { mutableStateOf(listOf()) },
    isTypingLottieShown: MutableState<Boolean> = remember { mutableStateOf(true) }

): MessageListState = remember(
    coroutineScope,
    lazyListState,
    onNextBlock,
    conversationMessages,
    isTypingLottieShown
) {
    MessageListState(
        coroutineScope = coroutineScope,
        lazyListState = lazyListState,
        onNextBlock = onNextBlock,
        conversationMessages = conversationMessages,
        isTypingLottieShown = isTypingLottieShown
    )
}