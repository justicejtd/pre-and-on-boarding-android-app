package com.example.preandonboarding.ui.conversationBase

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.preandonboarding.R
import com.example.preandonboarding.components.button.BackArrowButton
import com.example.preandonboarding.components.header.Header
import com.example.preandonboarding.components.image.CircleImage
import com.example.preandonboarding.components.image.Logo
import com.example.preandonboarding.data.model.user.User


@Composable
fun ConversationBasePageHeader(
    navController: NavController,
    user: User,
    modifier: Modifier = Modifier
) {
    val onTertiaryContainerColor = MaterialTheme.colorScheme.onTertiaryContainer

    Header(modifier = modifier.height(dimensionResource(id = R.dimen.appbar_default_height))) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Row(modifier = Modifier.align(Alignment.CenterStart)) {
                BackArrowButton(
                    navController = navController,
                    color = onTertiaryContainerColor,
                )
                CircleImage(
                    url = user.profile.image,
                    imageSize = 50.dp,
                    backgroundColor = onTertiaryContainerColor
                )
                ChatBio(
                    name = user.name, role = user.profile.role, modifier = Modifier.padding(
                        start = dimensionResource(
                            id = R.dimen.space_padding_medium
                        )
                    )
                )
            }
            Logo(
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = dimensionResource(id = R.dimen.space_padding_medium))
            )
        }
    }
}