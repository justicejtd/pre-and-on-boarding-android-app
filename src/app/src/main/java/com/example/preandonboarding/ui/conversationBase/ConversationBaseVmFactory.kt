package com.example.preandonboarding.ui.conversationBase

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.preandonboarding.data.model.conversation.Conversation
import com.example.preandonboarding.utils.handlers.block.BlockHandler
import com.example.preandonboarding.utils.constants.FactoryConstants.FACTORY_EXCEPTION_MSG
import java.lang.IllegalArgumentException

/**
 * Handles the initialization for ConversationBaseViewModel
 * @param blockHandler manages the block items of a conversation.
 */
class ConversationBaseVmFactory(
    private val conversation: Conversation,
    private val blockHandler: BlockHandler
) :
    ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ConversationBaseViewModel::class.java)) {
            return ConversationBaseViewModel(conversation = conversation, blockHandler = blockHandler) as T
        }
        throw IllegalArgumentException(FACTORY_EXCEPTION_MSG)
    }
}