package com.example.preandonboarding.components.vector

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import com.example.preandonboarding.R

/**
 * Image vector with custom rectangle.
 * @param colorFilter for tinting the vector image.
 */
@Composable
fun TopRectangleVector(modifier: Modifier = Modifier, colorFilter: ColorFilter? = null) {
    Image(
        imageVector = ImageVector.vectorResource(id = R.drawable.ic_vector_top_rectangle),
        contentDescription = stringResource(id = R.string.contentDescription_vector_top_rectangle),
        modifier = modifier,
        colorFilter = colorFilter,
        contentScale = ContentScale.FillWidth
    )
}