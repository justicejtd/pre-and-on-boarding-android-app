package com.example.blockitemcomponents.components.mediaBlockItem


import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.work.WorkManager
import com.example.blockitemcomponents.components.mediaBlockItem.fileDownload.FileDownload
import com.example.blockitemcomponents.components.mediaBlockItem.fileDownload.rememberFileDownloadState
import com.example.preandonboarding.R
import com.example.blockitemcomponents.components.mediaBlockItem.document.PdfViewer
import com.example.preandonboarding.components.image.NetworkImage
import com.example.preandonboarding.components.text.BodyMediumText
import com.example.blockitemcomponents.components.mediaBlockItem.video.VideoPlayer
import com.example.preandonboarding.utils.handlers.fileDownload.File
import com.example.preandonboarding.utils.enums.MediaType
import com.example.preandonboarding.utils.handlers.fileDownload.FileDownloadHandler
import com.example.preandonboarding.utils.navigation.Screen

private const val DOCUMENT_FILE_TYPE = "PDF"

@Composable
fun MediaBlockItem(navController: NavController, mediaBlockItemState: MediaBlockItemState) {
    val size = 200.dp

    Column {
        when (mediaBlockItemState.type) {
            MediaType.VIDEO.typeName -> {
                val playWhenReady by rememberSaveable { mutableStateOf(false) }
                VideoPlayer(
                    url = mediaBlockItemState.url,
                    playWhenReady = playWhenReady,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(size)
                )
            }

            MediaType.IMAGE.typeName -> {
                val imageUrl = Uri.encode(mediaBlockItemState.url)

                NetworkImage(
                    url = mediaBlockItemState.url,
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(min = 200.dp, max = 200.dp)
                        .clickable {
                            navController.navigate(route = Screen.FullScreenImage.route.plus("/$imageUrl"))
                        },
                    contentScale = ContentScale.FillWidth
                )
            }

            MediaType.DOCUMENT.typeName -> {
                if (mediaBlockItemState.isUrlForDownload()) {
                    val context = LocalContext.current
                    val workManager = WorkManager.getInstance(context)
                    val fileName = mediaBlockItemState.getFileName(mediaBlockItemState.url)
                    val file = File(fileName, DOCUMENT_FILE_TYPE, mediaBlockItemState.url)
                    val pdfDownloadState =
                        rememberFileDownloadState(FileDownloadHandler(workManager), file)

                    FileDownload(
                        fileDownloadState = pdfDownloadState, modifier = Modifier.padding(
                            dimensionResource(id = R.dimen.space_padding_small)
                        )
                    )
                } else {
                    PdfViewer(
                        uri = Uri.parse(mediaBlockItemState.url),
                        modifier = Modifier.fillMaxWidth().height(size)
                    )
                }
            }

            MediaType.GIF.typeName -> {
                NetworkImage(
                    url = mediaBlockItemState.url,
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(min = 50.dp),
                    contentScale = ContentScale.FillWidth
                )
            }
        }
        if (mediaBlockItemState.isMsgTextNotEmpty()) {
            BodyMediumText(
                text = mediaBlockItemState.msgText,
                modifier = Modifier.padding(dimensionResource(id = R.dimen.space_padding_small))
            )
        }
    }
}