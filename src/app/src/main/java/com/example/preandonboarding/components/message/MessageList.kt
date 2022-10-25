package com.example.preandonboarding.components.message

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.preandonboarding.R
import com.example.preandonboarding.components.composeRenderer.ComposeRenderer
import com.example.preandonboarding.components.loading.TypingAnimation
import com.example.preandonboarding.data.model.blockItem.BlockItem
import com.example.preandonboarding.data.model.blockItem.MapBlockItemData
import com.example.preandonboarding.data.model.blockItem.message.MessageBlockItem


@Composable
fun ColumnScope.MessageList(
    navController: NavController,
    startingBlockItems: List<BlockItem>,
    messageListState: MessageListState,
    onActionClick: (nextBlockId: Int, oldBlockItem: BlockItem, replyBlockItem: BlockItem) -> Unit,
    modifier: Modifier = Modifier
) {

    LaunchedEffect(Unit) {
        messageListState.runFlow(startingBlockItems)
    }

    LazyColumn(
        state = messageListState.lazyListState,
        verticalArrangement = Arrangement.spacedBy(
            dimensionResource(id = R.dimen.space_padding_medium)
        ),
        contentPadding = PaddingValues(
            horizontal = dimensionResource(id = R.dimen.space_padding_medium),
            vertical = dimensionResource(id = R.dimen.space_padding_medium)
        ),
        modifier = modifier
            .fillMaxSize()
            .weight(1f)
    ) {
        items(
            items = messageListState.conversationMessages.value,
        ) { blockItem ->
            val mapBlockItemData = MapBlockItemData(navController, onActionClick, blockItem)
            val isReply = blockItem is MessageBlockItem && blockItem.isReply

            Row(
                horizontalArrangement = if (isReply) Arrangement.End else Arrangement.Start,
                modifier = Modifier.fillMaxWidth()
            ) {
                MessageCard(isReply = isReply) {
                    ComposeRenderer(composeKey = blockItem.key, any = mapBlockItemData)
                }
            }
        }

        item {
            if (messageListState.isTypingLottieShown.value) {
                TypingAnimation(modifier = Modifier
                    .width(70.dp)
                    .height(30.dp))
            }
        }
    }
}