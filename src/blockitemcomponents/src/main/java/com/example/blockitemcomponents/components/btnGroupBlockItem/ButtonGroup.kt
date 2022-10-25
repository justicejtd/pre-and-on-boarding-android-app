package com.example.blockitemcomponents.components.btnGroupBlockItem

import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.example.preandonboarding.R
import com.example.preandonboarding.components.button.LargeButton
import com.example.preandonboarding.components.text.BodyMediumText
import com.example.preandonboarding.data.model.blockItem.BlockItem
import com.example.preandonboarding.data.model.blockItem.buttonGroup.ButtonGroup
import com.example.preandonboarding.data.model.blockItem.message.Text

@Composable
fun ButtonGroup(
    buttonGroup: ButtonGroup,
    onActionClick: (nextBlockId: Int, oldBlockItem: BlockItem, replyBlockItem: BlockItem) -> Unit,
    modifier: Modifier = Modifier
) {
    val cellSize = 100.dp
    val configuration = LocalConfiguration.current
    val maxGridWidth = (configuration.screenWidthDp * 0.70).dp
    val minGridWidth = maxGridWidth / 2
    val gridWidth = if (buttonGroup.buttons.size <= 1) minGridWidth else maxGridWidth

    Column(modifier = modifier) {
        if (buttonGroup.msgText.isNotEmpty()) {
            BodyMediumText(
                text = buttonGroup.msgText,
                modifier = Modifier.padding(
                    bottom = dimensionResource(
                        id = R.dimen.space_padding_extra_small
                    )
                )
            )
        }
        LazyVerticalGrid(
            columns = GridCells.Adaptive(cellSize),
            verticalArrangement = Arrangement.spacedBy(
                space = dimensionResource(id = R.dimen.space_padding_extra_small)
            ),
            horizontalArrangement = Arrangement.spacedBy(
                space = dimensionResource(id = R.dimen.space_padding_small)
            ),
            modifier = Modifier.width(gridWidth)
        ) {
            items(items = buttonGroup.buttons) {
                Row(horizontalArrangement = Arrangement.Start) {
                    LargeButton(
                        text = it.label,
                        onClick = {
                            onActionClick(
                                it.nexBlockId,
                                buttonGroup,
                                Text(
                                    msgText = it.label,
                                    position = 1,
                                    isReply = true
                                )
                            )
                        },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}