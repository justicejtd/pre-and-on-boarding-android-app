package com.example.preandonboarding.components.image

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.example.preandonboarding.R
import com.example.preandonboarding.ui.theme.DefaultShapes

@Composable
fun RoundedLogoImage(backgroundColor: Color, modifier: Modifier = Modifier, url: String) {
    Box(
        modifier = modifier
            .padding(dimensionResource(id = R.dimen.space_padding_medium))
            .clip(shape = DefaultShapes.small)
    ) {
        NetworkImage(
            url = url,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .size(size = 40.dp)
                .background(color = backgroundColor)
                .padding(2.dp)
        )
    }
}