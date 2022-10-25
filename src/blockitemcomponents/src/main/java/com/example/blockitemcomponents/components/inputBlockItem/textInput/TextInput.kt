package com.example.blockitemcomponents.components.inputBlockItem.textInput

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import com.example.preandonboarding.R
import com.example.preandonboarding.components.button.TextFieldButton
import com.example.preandonboarding.components.text.BodyMediumText
import com.example.preandonboarding.data.model.blockItem.BlockItem
import com.example.preandonboarding.data.model.blockItem.input.Input
import com.example.preandonboarding.ui.theme.DefaultShapes


@Composable
fun rememberTextInputState(
    input: Input,
    onActionClick: (nextBlockId: Int, oldBlockItem: BlockItem, replyBlockItem: BlockItem) -> Unit,
    isAction: Boolean,
) = remember {
    TextInputState(input, onActionClick, isAction)
}

@Composable
fun TextInput(
    textInputState: TextInputState, modifier: Modifier = Modifier
) {
    val localFocusManager = LocalFocusManager.current
    val isAction = textInputState.isAction

    Column(
        horizontalAlignment = Alignment.Start,
        modifier = modifier.padding(dimensionResource(id = R.dimen.space_padding_small))
    ) {
        BodyMediumText(text = textInputState.input.msgText)
        Spacer(modifier = Modifier.heightIn(dimensionResource(id = R.dimen.space_padding_extra_small)))
        TextField(
            value = textInputState.value,
            placeholder = { Text(stringResource(id = R.string.input_text_type_place_holder)) },
            onValueChange = { textInputState.onValueChange(it) },
            shape = DefaultShapes.large,
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = if (isAction) ImeAction.Done else ImeAction.Next
            ),
            keyboardActions = if (isAction) KeyboardActions(onDone = {
                textInputState.onClick()
                localFocusManager.clearFocus()
            }) else KeyboardActions(
                onNext = {
                    localFocusManager.moveFocus(FocusDirection.Next)
                }
            ),
            trailingIcon = {
                if (isAction) TextFieldButton(onclick = {
                    textInputState.onClick()
                    localFocusManager.clearFocus()
                })
            }
        )
    }
}

