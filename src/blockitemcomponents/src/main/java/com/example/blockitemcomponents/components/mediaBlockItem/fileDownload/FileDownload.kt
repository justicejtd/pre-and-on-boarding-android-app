package com.example.blockitemcomponents.components.mediaBlockItem.fileDownload

import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.blockitemcomponents.R
import com.example.preandonboarding.components.button.ButtonDownloadFile
import com.example.preandonboarding.components.button.ButtonOpenFile
import com.example.preandonboarding.utils.handlers.intent.IntentHandler

@Composable
fun FileDownload(fileDownloadState: FileDownloadState, modifier: Modifier = Modifier) {
    val toastErrorMsg = stringResource(id = R.string.message_can_not_open_pdf_file)
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current

    Box(modifier = modifier) {
        if (fileDownloadState.downloadedUri.value.isEmpty()) {
            ButtonDownloadFile(
                onClick = { fileDownloadState.onDownloadStart(lifecycleOwner) },
                isEnabled = fileDownloadState.isDownloading.value.not()
            )
        } else {
            val uri = fileDownloadState.getUri(context)
            ButtonOpenFile(onClick = { IntentHandler.openPdfFile(uri, context, toastErrorMsg) })
        }
        if (fileDownloadState.isDownloading.value) CircularProgressIndicator(
            color = MaterialTheme.colorScheme.secondary,
            modifier = Modifier.size(32.dp).align(Alignment.Center)
        )
    }
}