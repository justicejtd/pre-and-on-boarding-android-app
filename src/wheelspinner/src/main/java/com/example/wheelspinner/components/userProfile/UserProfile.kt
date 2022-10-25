package com.example.wheelspinner.components.userProfile

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.example.preandonboarding.R
import com.example.preandonboarding.data.model.user.User

@Composable
fun UserProfile(user: User, modifier: Modifier = Modifier) {
    val scrollableState = rememberScrollState()

    Column(
        modifier = modifier
            .verticalScroll(scrollableState)
            .heightIn(max = 5000.dp)
    ) {
        ProfileImage(userName = user.name, image = user.profile.image)
        Column(
            modifier = Modifier.padding(dimensionResource(id = R.dimen.space_padding_large))
        ) {
            ActionButtons(modifier = Modifier.fillMaxWidth(), user = user)
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.space_padding_large)))
            Description(user.profile.description)
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.space_padding_large)))
            Hobbies(hobbies = user.profile.hobbies)
        }
    }
}