package com.example.blockitemcomponents.components.inputBlockItem.groupInput

import androidx.compose.runtime.Composable
import com.example.preandonboarding.base.ComposeMediator
import com.example.preandonboarding.data.model.blockItem.MapBlockItemData
import com.example.preandonboarding.data.model.blockItem.input.GroupInput
import com.example.preandonboarding.utils.constants.ComposeKeys
import com.example.preandonboarding.utils.handlers.compose.ComposeRegistry

class GroupInputBlockItemMediator : ComposeMediator {
    override fun mapComposeArgs() {
        ComposeRegistry.registerComposable(ComposeKeys.GROUP_INPUT_BLOCK_ITEM, this)
    }

    @Composable
    override fun Render(any: Any) {
        if (any is MapBlockItemData) {
            val groupInput = any.blockItem

            if (groupInput is GroupInput) {
                val groupInputBlockItemState = rememberGroupInputBlockItemState(
                    groupInput = groupInput,
                    onActionClick = any.onActionClick
                )
                GroupInputBlockItem(groupInputBlockItemState)
            }
        }
    }
}