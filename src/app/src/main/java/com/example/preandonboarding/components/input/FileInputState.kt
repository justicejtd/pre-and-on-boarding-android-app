package com.example.preandonboarding.components.input

import android.content.Context
import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.example.preandonboarding.data.model.blockItem.BlockItem
import com.example.preandonboarding.data.model.blockItem.input.Input
import com.example.preandonboarding.data.model.blockItem.message.Media

private const val PDF_SUFFIX = ".pdf"

class FileInputState(
    val input: Input,
    val type: String,
    val onActionClick: (
        nextBlockId: Int,
        oldBlockItem: BlockItem,
        replyBlockItem: BlockItem
    ) -> Unit
) {

    fun onResults(uri: Uri, context: Context) {
        val pdfName = FilePathHelper.getFileName(uri)

        val file = kotlin.io.path.createTempFile(prefix = pdfName, suffix = PDF_SUFFIX).toFile()
        FilePathHelper.copyInputToFile(context, uri, file)

        onActionClick(
            input.nexBlockId,
            input,
            Media(
                msgText = pdfName,
                position = 1,
                isReply = true,
                type = input.type,
                url = file.path
            )
        )
    }
}

@Composable
fun rememberFileInputState(
    input: Input,
    type: String,
    onActionClick: (
        nextBlockId: Int,
        oldBlockItem: BlockItem,
        replyBlockItem: BlockItem
    ) -> Unit
) =
    remember(input, onActionClick, type) {
        FileInputState(input = input, type = type,onActionClick = onActionClick)
    }