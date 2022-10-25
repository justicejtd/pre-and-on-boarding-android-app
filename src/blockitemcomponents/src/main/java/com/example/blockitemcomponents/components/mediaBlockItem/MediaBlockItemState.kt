package com.example.blockitemcomponents.components.mediaBlockItem

import androidx.compose.runtime.*

private const val FILE_NAME_DELIMITER_AFTER = "Documents%2F"
private const val FILE_NAME_DELIMITER_BEFORE = ".pdf"
private const val URL_PREFIX = "https"

class MediaBlockItemState(val msgText: String, val type: String, val url: String) {
    val isUrlForDownload = { url.contains(URL_PREFIX) }
    val isMsgTextNotEmpty = { msgText.isNotEmpty() }

    fun getFileName(url: String): String {
        var fileName = url.substringAfter(FILE_NAME_DELIMITER_AFTER)
        fileName = fileName.substringBefore(FILE_NAME_DELIMITER_BEFORE)
        return fileName
    }
}

@Composable
fun rememberMediaBlockItemState(msgText: String, type: String, url: String) =
    remember { MediaBlockItemState(msgText = msgText, type = type, url = url) }