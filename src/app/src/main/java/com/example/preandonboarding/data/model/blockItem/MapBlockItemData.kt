package com.example.preandonboarding.data.model.blockItem

import androidx.navigation.NavController

class MapBlockItemData(
    val navController: NavController,
    val onActionClick: (nextBlockId: Int, oldBlockItem: BlockItem, replyBlockItem: BlockItem) -> Unit,
    val blockItem: BlockItem
)
