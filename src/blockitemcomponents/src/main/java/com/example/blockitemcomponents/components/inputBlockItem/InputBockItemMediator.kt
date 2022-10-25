package com.example.blockitemcomponents.components.inputBlockItem

import androidx.compose.runtime.Composable
import com.example.preandonboarding.base.ComposeMediator
import com.example.preandonboarding.data.model.blockItem.MapBlockItemData
import com.example.preandonboarding.data.model.blockItem.input.Input
import com.example.preandonboarding.utils.handlers.compose.ComposeRegistry
import com.example.preandonboarding.utils.constants.ComposeKeys


class InputBockItemMediator : ComposeMediator {

    override fun mapComposeArgs() {
        ComposeRegistry.registerComposable(ComposeKeys.INPUT_BLOCK_ITEM, this)
    }

    @Composable
    override fun Render(any: Any) {
        if (any is MapBlockItemData) {
            val input = any.blockItem

            if (input is Input) {
                InputBlockItem(input, any.onActionClick)
            }
        }
    }
}
