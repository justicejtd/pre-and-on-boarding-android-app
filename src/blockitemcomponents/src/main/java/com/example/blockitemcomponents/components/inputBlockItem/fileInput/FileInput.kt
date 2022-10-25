package com.example.blockitemcomponents.components.inputBlockItem.fileInput

import android.Manifest
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import com.example.preandonboarding.R
import com.example.preandonboarding.components.button.LargeButton
import com.example.preandonboarding.components.input.FileInputState
import com.example.preandonboarding.components.text.BodyMediumText
import com.example.preandonboarding.data.model.blockItem.message.Media
import com.example.preandonboarding.utils.handlers.permission.PermissionHandler
import com.example.preandonboarding.utils.constants.ComposeKeys
import com.example.preandonboarding.utils.constants.MimeType.MIME_TYPE_IMAGE
import com.example.preandonboarding.utils.enums.MediaType

private const val PERMISSION_DENIED_MSG = "Permission denied"

@Composable
fun FileInput(
    fileInputState: FileInputState,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val launcherForFiles =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.OpenDocument(),
            onResult = {
                if (it != null) {
                    if (fileInputState.type == MIME_TYPE_IMAGE) {
                        fileInputState.onActionClick(
                            fileInputState.input.nexBlockId,
                            fileInputState.input,
                            Media(
                                msgText = "",
                                position = 1,
                                isReply = true,
                                type = MediaType.IMAGE.typeName,
                                url = it.toString(),
                                key = ComposeKeys.MEDIA_BLOCK_ITEM
                            )
                        )
                    } else {
                        fileInputState.onResults(it, context)
                    }
                }
            }
        )

    val launcherForPermission =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.RequestPermission(),
            onResult = {
                if (it) {
                    launcherForFiles.launch(arrayOf(fileInputState.type))
                } else {
                    Toast.makeText(context, PERMISSION_DENIED_MSG, Toast.LENGTH_LONG).show()
                }
            }
        )

    Column(modifier = modifier) {
        BodyMediumText(text = fileInputState.input.msgText)
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.space_padding_small)))
        LargeButton(
            text = stringResource(id = R.string.input_file_button_text),
            icon = ImageVector.vectorResource(id = R.drawable.ic_file_document_plus),
            contentDescription = stringResource(id = R.string.contentDescription_icon_document_add),
            onClick = {
                if (PermissionHandler.isScopedStoragePermissionNeeded()) {
                    launcherForPermission.launch(Manifest.permission.READ_EXTERNAL_STORAGE)

                } else {
                    launcherForFiles.launch(arrayOf(fileInputState.type))
                }
            }
        )
    }
}