package com.example.blockitemcomponents.components.btnGroupBlockItem

import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.example.preandonboarding.R
import com.example.preandonboarding.data.model.blockItem.BlockItem
import com.example.preandonboarding.data.model.blockItem.buttonGroup.ButtonGroup

@Composable
fun BtnGroupBlockItem(
    buttonGroup: ButtonGroup,
    onActionClick: (nextBlockId: Int, oldBlockItem: BlockItem, replyBlockItem: BlockItem) -> Unit
) {
    ButtonGroup(
        buttonGroup = buttonGroup,
        onActionClick = onActionClick,
        modifier = Modifier.heightIn(max = 500.dp).padding(dimensionResource(id = R.dimen.space_padding_small))
    )
}