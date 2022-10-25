package com.example.preandonboarding.ui.login.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import com.example.preandonboarding.R
import com.example.preandonboarding.components.error.ErrorField
import com.example.preandonboarding.ui.login.state.EmailState
import com.example.preandonboarding.ui.theme.DefaultShapes

/**
 * TextField for entering email.
 */
@Composable
fun EmailInputField(
    emailState: EmailState,
    onImeAction: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        OutlinedTextField(
            value = emailState.text,
            onValueChange = {
                emailState.text = it
                emailState.validate()
            },
            label = { Text(text = stringResource(id = R.string.hint_email)) },
            shape = DefaultShapes.large,
            isError = emailState.error != null,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = stringResource(id = R.string.contentDescription_icon_email)
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = { onImeAction() }
            ),
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        // Show error message if email is invalid
        emailState.error?.let { ErrorField(error = it) }
    }
}