package com.example.wheelspinner.components.userProfile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.preandonboarding.components.image.NetworkImage
import com.example.preandonboarding.ui.theme.ProfileImageShapes
import com.example.wheelspinner.R

@Composable
fun ProfileImage(userName: String, image: String, modifier: Modifier = Modifier) {
    val configuration = LocalConfiguration.current
    val height = configuration.screenHeightDp * 0.30

    Box(
        modifier = modifier
            .height(height.dp)
            .clip(ProfileImageShapes.large)
            .background(MaterialTheme.colorScheme.tertiaryContainer)
    ) {
        NetworkImage(
            url = image,
            contentDescription = stringResource(id = R.string.contentDescription_user_profile_image),
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = height.dp)
        )
        Text(
            text = userName,
            style = MaterialTheme.typography.displayLarge,
            color = Color.White,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(start = dimensionResource(id = com.example.preandonboarding.R.dimen.space_padding_large))
        )
    }
}