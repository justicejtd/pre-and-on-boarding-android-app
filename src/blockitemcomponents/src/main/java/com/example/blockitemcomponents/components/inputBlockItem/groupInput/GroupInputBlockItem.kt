package com.example.blockitemcomponents.components.inputBlockItem.groupInput

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.example.blockitemcomponents.components.inputBlockItem.InputBlockItem
import com.example.preandonboarding.data.model.blockItem.BlockItem
import com.example.preandonboarding.data.model.blockItem.input.GroupInput

@Composable
fun rememberGroupInputBlockItemState(
    groupInput: GroupInput,
    onActionClick: (nextBlockId: Int, oldBlockItem: BlockItem, replyBlockItem: BlockItem) -> Unit
) =
    remember(groupInput) { GroupInputBlockItemState(groupInput, onActionClick) }

@Composable
fun GroupInputBlockItem(
    groupInputBlockItemState: GroupInputBlockItemState,
) {
    val inputs = groupInputBlockItemState.groupInput.inputs
    Column(
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        inputs.forEach {
            val isButtonVisible = groupInputBlockItemState.isButtonVisible(it)
            InputBlockItem(
                input = it,
                onActionClick = groupInputBlockItemState.onActionGroupClick,
                isAction = isButtonVisible,
            )
        }
    }
}