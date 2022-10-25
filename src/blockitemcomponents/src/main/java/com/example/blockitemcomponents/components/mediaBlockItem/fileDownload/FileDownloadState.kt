package com.example.blockitemcomponents.components.mediaBlockItem.fileDownload

import android.content.Context
import android.net.Uri
import androidx.compose.runtime.*
import androidx.core.content.FileProvider
import androidx.core.net.toUri
import androidx.lifecycle.LifecycleOwner
import com.example.preandonboarding.components.input.FilePathHelper
import com.example.preandonboarding.utils.handlers.fileDownload.File
import com.example.preandonboarding.utils.handlers.fileDownload.FileDownloadHandler

private const val FILE_PROVIDER_NAME = ".provider"


@Composable
fun rememberFileDownloadState(
    fileDownloadHandler: FileDownloadHandler, file: File,
    downloadedUri: MutableState<String> = remember { mutableStateOf("") },
    isDownloading: MutableState<Boolean> = remember { mutableStateOf(false) },
) =
    remember(fileDownloadHandler) {
        FileDownloadState(
            fileDownloadHandler,
            file,
            downloadedUri,
            isDownloading
        )
    }

class FileDownloadState(
    private val fileDownloadHandler: FileDownloadHandler,
    private val file: File,
    val downloadedUri: MutableState<String>,
    val isDownloading: MutableState<Boolean>,
) {

    fun onDownloadStart(
        context: LifecycleOwner
    ) {
        fileDownloadHandler.startDownloadingFile(
            file = file,
            success = { onSuccess(it) },
            failed = { onFail() },
            context = context,
            running = { onRunning() }
        )
    }

    private fun onSuccess(downloadedUri: String) {
        isDownloading.value = false
        this.downloadedUri.value = downloadedUri
    }

    private fun onFail() {
        isDownloading.value = false
        downloadedUri.value = ""
    }

    private fun onRunning() {
        isDownloading.value = true
    }

    fun getUri(context: Context): Uri {
        val pathName =
            downloadedUri.value.let { FilePathHelper.getPath(it.toUri(), context) }
        val file = java.io.File(pathName.toString())

        return FileProvider.getUriForFile(
            context,
            context.applicationContext.packageName + FILE_PROVIDER_NAME,
            file
        )
    }
}