package com.example.blockitemcomponents.components.inputBlockItem.groupInput

import com.example.preandonboarding.data.model.blockItem.BlockItem
import com.example.preandonboarding.data.model.blockItem.input.GroupInput
import com.example.preandonboarding.data.model.blockItem.input.Input

class GroupInputBlockItemState(
    val groupInput: GroupInput,
    private val onActionClick: (nextBlockId: Int, oldBlockItem: BlockItem, replyBlockItem: BlockItem) -> Unit
) {

    val onActionGroupClick: (nextBlockId: Int, oldBlockItem: BlockItem, replyBlockItem: BlockItem) -> Unit =
        { nextBlockId, oldBlockItem, replyBlockItem ->
            run {
                replyBlockItem.msgText = getGroupText()
                onActionClick(nextBlockId, oldBlockItem, replyBlockItem)
            }
        }

    private fun getGroupText(): String {
        var replyText = ""
        groupInput.inputs.forEach {
            replyText += it.replyText + "\n"
        }
        return replyText
    }

    fun isButtonVisible(input: Input): Boolean {
        val inputs = groupInput.inputs
        return inputs.lastIndex == inputs.indexOf(input)
    }
}