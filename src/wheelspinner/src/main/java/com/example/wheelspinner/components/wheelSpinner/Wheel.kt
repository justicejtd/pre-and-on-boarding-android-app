package com.example.wheelspinner.components.wheelSpinner

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.*
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun Wheel(
    modifier: Modifier = Modifier,
    size: Dp = 300.dp,
    imageBitmaps: List<ImageBitmap>,
) {
    val secondaryColor = MaterialTheme.colorScheme.secondary
    val tertiaryColor = MaterialTheme.colorScheme.tertiary

    androidx.compose.foundation.Canvas(modifier = modifier.size(size)) {
        val sizeInPixels = size.toPx()
        val initialPosition = 247.5f

        imageBitmaps.forEach {
            val i = imageBitmaps.indexOf(it)

            if (i <= 7) {
                val remainder = i % 2
                var sweepAngle = 45f
                val color = if (remainder == 0) secondaryColor else tertiaryColor
                var startAngle = i * 45f + initialPosition

                drawArc(
                    color = color,
                    startAngle = startAngle,
                    topLeft = Offset(x = 0f, y = 0f),
                    sweepAngle = sweepAngle,
                    useCenter = true,
                    size = Size(sizeInPixels, sizeInPixels),
                )

                val radius = sizeInPixels / 2.75f
                val circumference = (sizeInPixels * Math.PI).toFloat()
                startAngle = 67.5f * circumference / 360
                val imageSize = sizeInPixels.toInt() / 6
                sweepAngle =
                    i * (circumference) / ((imageSize * Math.PI) * 7.7).toFloat()
                val imageCenterPoint = (imageSize / 2)
                val x = (radius * cos(startAngle + sweepAngle) + center.x) - imageCenterPoint
                val y = (radius * sin(startAngle + sweepAngle) + center.y) - imageCenterPoint

                drawImage(
                    image = it,
                    dstOffset = IntOffset(
                        x = x.toInt(),
                        y = y.toInt(),
                    ),
                    dstSize = IntSize(imageSize, imageSize),
                    filterQuality = FilterQuality.Low,
                )
                drawCircle(
                    color = color,
                    radius = (imageSize / 2f),
                    center = Offset(x + imageCenterPoint, y + imageCenterPoint),
                    style = Stroke(
                        width = imageSize * 0.18f,
                    )
                )
                drawRect(
                    color = color,
                    topLeft = Offset(x, y),
                    size = Size(imageSize.toFloat(), imageSize.toFloat()),
                    style = Stroke(width = imageSize * 0.16f)
                )
            }
        }
    }
}