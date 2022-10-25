package com.example.preandonboarding.components.indicator

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun StaticCircularProgressIndicator(
    progress: Float,
    strokeWidth: Dp = 7.dp,
    color: Color = MaterialTheme.colorScheme.secondary,
    style: TextStyle = LocalTextStyle.current,
    modifier: Modifier = Modifier.size(100.dp)
) {
    Box(modifier = modifier) {
        val progressLeft = -1 + progress

        CircularProgressIndicator(
            strokeWidth = strokeWidth,
            color = color.copy(alpha = 0.4f),
            progress = progressLeft,
            modifier = modifier
                .align(Alignment.Center)
        )
        CircularProgressIndicator(
            strokeWidth = strokeWidth,
            color = color,
            progress = progress,
            modifier = modifier.align(Alignment.Center)
        )
        Text(
            text = "${(progress * 100).toInt()}%",
            modifier = Modifier.align(Alignment.Center),
            style = style
        )
    }
}