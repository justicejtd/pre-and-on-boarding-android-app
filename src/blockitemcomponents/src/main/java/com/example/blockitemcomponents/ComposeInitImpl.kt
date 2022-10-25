package com.example.blockitemcomponents

import com.example.blockitemcomponents.components.btnGroupBlockItem.BtnGroupBlockItemMediator
import com.example.blockitemcomponents.components.groupBlockItem.GroupBlockItemMediator
import com.example.blockitemcomponents.components.inputBlockItem.groupInput.GroupInputBlockItemMediator
import com.example.blockitemcomponents.components.inputBlockItem.InputBockItemMediator
import com.example.blockitemcomponents.components.mediaBlockItem.MediaBlockItemMediator
import com.example.blockitemcomponents.components.textBlockItem.TextBlockItemMediator
import com.example.preandonboarding.base.ComposeInit
import com.example.preandonboarding.base.ComposeMediator

class ComposeInitImpl(private var mediators: List<ComposeMediator> = listOf()) : ComposeInit {

    init {
        mediators = listOf(
            TextBlockItemMediator(), MediaBlockItemMediator(), InputBockItemMediator(),
            BtnGroupBlockItemMediator(), GroupInputBlockItemMediator(), GroupBlockItemMediator()
        )
    }

    override fun initializeCompose() {
        mediators.forEach {
            it.mapComposeArgs()
        }
    }

    companion object Provider : ComposeInit.Provider {
        override fun get(): ComposeInit {
            return ComposeInitImpl()
        }
    }
}