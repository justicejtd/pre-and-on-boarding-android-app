package com.example.blockitemcomponents.components.inputBlockItem

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.example.blockitemcomponents.components.inputBlockItem.fileInput.FileInput
import com.example.blockitemcomponents.components.inputBlockItem.textInput.TextInput
import com.example.blockitemcomponents.components.inputBlockItem.textInput.rememberTextInputState
import com.example.preandonboarding.R
import com.example.preandonboarding.components.input.rememberFileInputState
import com.example.preandonboarding.data.model.blockItem.BlockItem
import com.example.preandonboarding.data.model.blockItem.input.Input
import com.example.preandonboarding.utils.constants.MimeType.MIME_TYPE_IMAGE
import com.example.preandonboarding.utils.constants.MimeType.MIME_TYPE_PDF
import com.example.preandonboarding.utils.enums.InputType

@Composable
fun InputBlockItem(
    input: Input,
    onActionClick: (nextBlockId: Int, oldBlockItem: BlockItem, replyBlockItem: BlockItem) -> Unit,
    isAction: Boolean = true,
) {
    when (input.type) {
        InputType.TEXT.typeName -> {
            val textInputState = rememberTextInputState(input, onActionClick, isAction)
            TextInput(textInputState)
        }
        InputType.IMAGE.typeName -> {
            val fileInputState = rememberFileInputState(
                input = input,
                type = MIME_TYPE_IMAGE,
                onActionClick = onActionClick
            )
            FileInput(
                fileInputState = fileInputState,
                modifier = Modifier.padding(
                    dimensionResource(id =  R.dimen.space_padding_medium)
                )
            )
        }
        InputType.DOCUMENT.typeName -> {
            val fileInputState = rememberFileInputState(
                input = input,
                type = MIME_TYPE_PDF,
                onActionClick = onActionClick
            )
            FileInput(
                fileInputState = fileInputState,
                modifier = Modifier.padding(
                    dimensionResource(id = R.dimen.space_padding_medium)
                )
            )
        }
    }
}