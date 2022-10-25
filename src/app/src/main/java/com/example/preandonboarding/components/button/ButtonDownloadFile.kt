package com.example.preandonboarding.components.button

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FileDownload
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.preandonboarding.R

@Composable
fun ButtonDownloadFile(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true
) {
    LargeButton(
        text = stringResource(id = R.string.label_download_file_button_text),
        icon = Icons.Default.FileDownload,
        contentDescription = stringResource(id = R.string.contentDescription_icon_document_add),
        onClick = { onClick() },
        modifier = modifier,
        isEnabled = isEnabled,
    )
}