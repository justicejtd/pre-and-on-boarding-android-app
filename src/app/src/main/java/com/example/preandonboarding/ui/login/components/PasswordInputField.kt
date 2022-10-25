package com.example.preandonboarding.ui.login.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.example.preandonboarding.R
import com.example.preandonboarding.components.button.PasswordVisibilityIconButton
import com.example.preandonboarding.components.error.ErrorField
import com.example.preandonboarding.ui.login.state.PasswordState
import com.example.preandonboarding.ui.theme.DefaultShapes

/**
 * TextField for entering password.
 */
@Composable
fun PasswordInputField(
    passwordState: PasswordState,
    onImeAction: () -> Unit
) {
    Column {
        OutlinedTextField(
            value = passwordState.text,
            onValueChange = {
                passwordState.text = it
                passwordState.validate()
            },
            label = { Text(text = stringResource(id = R.string.hint_password)) },
            shape = DefaultShapes.large,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(onDone = { onImeAction() }),
            visualTransformation = getPasswordVisualTransformation(
                isPasswordVisible = passwordState.isVisible
            ),
            trailingIcon = {
                PasswordVisibilityIconButton(
                    isPasswordVisible = passwordState.isVisible,
                    onShowPassword = { passwordState.onShowPassword() }
                )
            },
            isError = passwordState.error != null,
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        // Show error message if password is empty
        passwordState.error?.let { ErrorField(error = it) }
    }
}

private fun getPasswordVisualTransformation(
    isPasswordVisible: Boolean,
): VisualTransformation {
    return if (!isPasswordVisible) {
        PasswordVisualTransformation()
    } else {
        VisualTransformation.None
    }
}