package com.example.blockitemcomponents.components.inputBlockItem.textInput

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.preandonboarding.data.model.blockItem.BlockItem
import com.example.preandonboarding.data.model.blockItem.input.Input

/**
 * Manages the states of the text input type.
 * @param input - Input data class.
 * @param onActionClick - Used to switch between block flow item.
 * @param isAction - Determines if the TextInput field is used to trigger an action.
 */
class TextInputState(
    val input: Input,
    val onActionClick: (nextBlockId: Int, oldBlockItem: BlockItem, replyBlockItem: BlockItem) -> Unit,
    val isAction: Boolean,
) {
    /**
     * Keeps track of the input value coming from the text field.
     */
    var value by mutableStateOf("")
        private set

    /**
     * Set text field value
     * @param value - The value coming from the text field
     */
    fun onValueChange(value: String) {
        this.value = value
        input.replyText = value
    }

    /**
     * Performs conversation onActionClick function.
     */
    fun onClick() {
        onActionClick(
            input.nexBlockId,
            input,
            com.example.preandonboarding.data.model.blockItem.message.Text(
                msgText = value,
                position = 1,
                isReply = true
            )
        )
    }
}