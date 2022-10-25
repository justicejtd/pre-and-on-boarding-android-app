package com.example.preandonboarding.ui.conversationBase

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.preandonboarding.components.message.MessageList
import com.example.preandonboarding.components.message.rememberMessageListState
import com.example.preandonboarding.data.model.conversation.Conversation
import com.example.preandonboarding.utils.handlers.block.BlockHandler
import com.google.accompanist.systemuicontroller.rememberSystemUiController

/**
 * Page for showing boarding conversation message.
 * @param conversationBaseViewModel
 */
@Composable
fun ConversationBasePage(
    conversation: Conversation,
    navController: NavController,
    conversationBaseViewModel: ConversationBaseViewModel = viewModel(
        factory = ConversationBaseVmFactory(
            conversation = conversation,
            blockHandler = BlockHandler(conversation.blocks)
        )
    )
) {
    conversationBaseViewModel.messageListState =
        rememberMessageListState(onNextBlock = { conversationBaseViewModel.onNextBlock(it) })

    val systemUiController = rememberSystemUiController()
    val systemBarsColor = MaterialTheme.colorScheme.tertiaryContainer
    val onSystemBarsColor = MaterialTheme.colorScheme.onTertiaryContainer

    SideEffect {
        systemUiController.setStatusBarColor(
            color = systemBarsColor,
            transformColorForLightContent = { onSystemBarsColor }
        )
    }

    Box {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.background)
        ) {
            ConversationBasePageHeader(
                navController = navController,
                user = conversationBaseViewModel.conversation.user,
                modifier = Modifier.background(MaterialTheme.colorScheme.tertiaryContainer)
            )
            MessageList(
                navController = navController,
                startingBlockItems = conversationBaseViewModel.getStartingBlockItems(),
                messageListState = conversationBaseViewModel.messageListState,
                onActionClick = { blockId, oldBlockItem, replyBlockItem ->
                    conversationBaseViewModel.onActionClick(
                        nextBlockId = blockId,
                        oldBlockItem = oldBlockItem,
                        replyBlockItem = replyBlockItem
                    )
                })
        }
    }
}