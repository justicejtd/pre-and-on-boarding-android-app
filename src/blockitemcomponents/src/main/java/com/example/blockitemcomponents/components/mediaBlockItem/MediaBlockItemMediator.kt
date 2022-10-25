package com.example.blockitemcomponents.components.mediaBlockItem

import androidx.compose.runtime.Composable
import com.example.preandonboarding.base.ComposeMediator
import com.example.preandonboarding.data.model.blockItem.MapBlockItemData
import com.example.preandonboarding.data.model.blockItem.message.Media
import com.example.preandonboarding.utils.handlers.compose.ComposeRegistry
import com.example.preandonboarding.utils.constants.ComposeKeys

class MediaBlockItemMediator : ComposeMediator {

    override fun mapComposeArgs() {
        ComposeRegistry.registerComposable(ComposeKeys.MEDIA_BLOCK_ITEM, this)
    }

    @Composable
    override fun Render(any: Any) {
        if (any is MapBlockItemData) {
            val media = any.blockItem

            if (media is Media) {
                val mediaBlockItemState = rememberMediaBlockItemState(
                    msgText = media.msgText,
                    type = media.type,
                    url = media.url
                )
                MediaBlockItem(
                    navController = any.navController,
                    mediaBlockItemState
                )
            }
        }
    }
}