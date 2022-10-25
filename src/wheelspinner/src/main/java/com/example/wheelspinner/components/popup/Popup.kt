package com.example.wheelspinner.components.popup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.example.preandonboarding.components.button.CloseButton
import com.example.preandonboarding.components.overlayBackground.OverlayBackground

@Composable
fun Popup(onClose: () -> Unit, content: @Composable () -> Unit) {
    val configuration = LocalConfiguration.current
    val popupWidth = (configuration.screenWidthDp * 0.8).dp
    val popupHeight = (configuration.screenHeightDp * 0.9).dp

    // Move popup 130 pixels to bottom right
    val offset = IntOffset(130, 130)

    androidx.compose.ui.window.Popup(
        offset = offset,
        alignment = Alignment.Center,
        onDismissRequest = { onClose() }
    ) {
        OverlayBackground {
            // Draw a rectangle shape with rounded corners inside the popup
            Box(
                Modifier
                    .size(popupWidth, popupHeight)
                    .background(Color.White, MaterialTheme.shapes.large)
                    .clip(MaterialTheme.shapes.large)
            ) {
                content()
                CloseButton(
                    onClick = { onClose() },
                    modifier = Modifier.align(Alignment.TopEnd)
                )
            }
        }
    }
}