package com.example.blockitemcomponents.components.groupBlockItem

import androidx.compose.runtime.Composable
import com.example.preandonboarding.base.ComposeMediator
import com.example.preandonboarding.components.composeRenderer.ComposeRenderer
import com.example.preandonboarding.data.model.blockItem.MapBlockItemData
import com.example.preandonboarding.data.model.blockItem.group.GroupBlockItem
import com.example.preandonboarding.utils.constants.ComposeKeys
import com.example.preandonboarding.utils.handlers.compose.ComposeRegistry

class GroupBlockItemMediator : ComposeMediator {
    override fun mapComposeArgs() {
        ComposeRegistry.registerComposable(ComposeKeys.GROUP_BLOCK_ITEM, this)
    }

    @Composable
    override fun Render(any: Any) {
        if (any is MapBlockItemData) {
            val groupBlockItem = any.blockItem

            if (groupBlockItem is GroupBlockItem) {
                groupBlockItem.blockItems.forEach { blockItem ->
                    val itemMap = MapBlockItemData(any.navController, any.onActionClick, blockItem)

                    ComposeRenderer(composeKey = blockItem.key, any = itemMap)
                }
            }
        }
    }
}