package com.example.blockitemcomponents.components.btnGroupBlockItem

import androidx.compose.runtime.Composable
import com.example.preandonboarding.base.ComposeMediator
import com.example.preandonboarding.data.model.blockItem.MapBlockItemData
import com.example.preandonboarding.data.model.blockItem.buttonGroup.ButtonGroup
import com.example.preandonboarding.utils.handlers.compose.ComposeRegistry
import com.example.preandonboarding.utils.constants.ComposeKeys

class BtnGroupBlockItemMediator : ComposeMediator {

    override fun mapComposeArgs() {
        ComposeRegistry.registerComposable(ComposeKeys.BUTTON_GROUP_BLOCK_ITEM, this)
    }

    @Composable
    override fun Render(any: Any) {
        if (any is MapBlockItemData) {
            val buttonGroup = any.blockItem

            if (buttonGroup is ButtonGroup) {
                BtnGroupBlockItem(buttonGroup, any.onActionClick)
            }
        }
    }
}