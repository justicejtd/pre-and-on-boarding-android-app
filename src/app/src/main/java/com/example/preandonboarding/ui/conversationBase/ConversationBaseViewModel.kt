package com.example.preandonboarding.ui.conversationBase

import androidx.lifecycle.ViewModel
import com.example.preandonboarding.components.message.MessageListState
import com.example.preandonboarding.data.model.blockItem.BlockItem
import com.example.preandonboarding.data.model.conversation.Conversation
import com.example.preandonboarding.utils.handlers.block.BlockHandler

/**
 * Handles the boarding conversation steps and messages.
 */
class ConversationBaseViewModel(
    val conversation: Conversation,
    private val blockHandler: BlockHandler
) : ViewModel() {

    lateinit var messageListState: MessageListState

    fun getStartingBlockItems(): List<BlockItem> {
        return blockHandler.getStartingBlock()?.getBlockItems() ?: listOf()
    }

    fun onActionClick(nextBlockId: Int, oldBlockItem: BlockItem, replyBlockItem: BlockItem) {
        messageListState.removeBlockItem(oldBlockItem)
        messageListState.addBlockItem(replyBlockItem)
        onNextBlock(nextBlockId)
    }

    fun onNextBlock(nextBlockId: Int) {
        val nextBlock = blockHandler.getBlockById(nextBlockId)

        nextBlock?.let {
            messageListState.runFlow(nextBlock.getBlockItems())
        }
    }
}