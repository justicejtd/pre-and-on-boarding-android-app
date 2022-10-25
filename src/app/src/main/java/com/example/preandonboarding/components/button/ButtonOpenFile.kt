package com.example.preandonboarding.components.button

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FileOpen
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.preandonboarding.R

@Composable
fun ButtonOpenFile(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true
) {
    LargeButton(
        text = stringResource(id = R.string.label_open_file_button_text),
        icon = Icons.Default.FileOpen,
        contentDescription = stringResource(id = R.string.contentDescription_icon_document_add),
        onClick = { onClick() },
        isEnabled = isEnabled,
        modifier = modifier
    )
}