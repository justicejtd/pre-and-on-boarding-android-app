package com.example.preandonboarding.components.blockItemState

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import com.example.preandonboarding.data.model.blockItem.BlockItem

/**
 * @param blockItem
 * @param onActionClick
 */
class BlockItemState(
    val navController: NavController,
    val blockItem: BlockItem,
    val onActionClick: (nextBlockId: Int, oldBlockItem: BlockItem, replyBlockItem: BlockItem) -> Unit,
)

@Composable
fun rememberBlockItemState(
    navController: NavController,
    blockItem: BlockItem,
    onActionClick: (nextBlockId: Int, oldBlockItem: BlockItem, replyBlockItem: BlockItem) -> Unit,
) = remember(blockItem) {
    BlockItemState(
        navController = navController,
        blockItem = blockItem,
        onActionClick = onActionClick
    )
}