package com.example.preandonboarding.components.image

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.preandonboarding.R

/**
 * Uses network image to get and show user image.
 * @param url of the user image.
 * @param backgroundColor is the color behind the image.
 */
@Composable
fun CircleImage(
    url: String,
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color.Unspecified,
    imageSize: Dp = 25.dp
) {
    Box(
        modifier = modifier
            .shadow(elevation = 4.dp, shape = CircleShape)
            .background(MaterialTheme.colorScheme.surface)
    ) {
        NetworkImage(
            url = url,
            contentDescription = stringResource(id = R.string.contentDescription_image_user),
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .size(size = imageSize)
                .background(color = backgroundColor)
        )
    }
}