package com.example.blockitemcomponents.components.textBlockItem

import androidx.compose.runtime.Composable
import com.example.preandonboarding.base.ComposeMediator
import com.example.preandonboarding.data.model.blockItem.MapBlockItemData
import com.example.preandonboarding.data.model.blockItem.message.Text
import com.example.preandonboarding.utils.handlers.compose.ComposeRegistry
import com.example.preandonboarding.utils.constants.ComposeKeys

class TextBlockItemMediator : ComposeMediator {
    override fun mapComposeArgs() {
        ComposeRegistry.registerComposable(ComposeKeys.TEXT_BLOCK_ITEM, this)
    }

    @Composable
    override fun Render(any: Any) {
        if (any is MapBlockItemData) {
            val text = any.blockItem

            if (text is Text) {
                TextBlockItem(msgText = text.msgText)
            }
        }
    }
}