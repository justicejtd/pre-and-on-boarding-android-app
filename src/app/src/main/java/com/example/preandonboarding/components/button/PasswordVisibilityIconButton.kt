package com.example.preandonboarding.components.button

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.preandonboarding.R

/**
 * Icon button for showing and hiding password
 */
@Composable
fun PasswordVisibilityIconButton(
    isPasswordVisible: Boolean,
    onShowPassword: () -> Unit,
) {
    IconButton(onClick = { onShowPassword() }) {
        if (!isPasswordVisible) {
            Icon(
                imageVector = Icons.Default.VisibilityOff,
                contentDescription = stringResource(
                    id = R.string.contentDescription_icon_showPassword
                ),
            )
        } else {
            Icon(
                imageVector = Icons.Default.Visibility,
                contentDescription = stringResource(
                    id = R.string.contentDescription_icon_showPassword
                ),
            )
        }
    }
}
