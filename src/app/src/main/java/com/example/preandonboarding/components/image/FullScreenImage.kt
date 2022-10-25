package com.example.preandonboarding.components.image

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.preandonboarding.components.button.BackArrowButton

@Composable
fun FullScreenImage(
    url: String,
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        NetworkImage(
            url = url,
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 50.dp)
                .align(Alignment.Center),
            contentScale = ContentScale.FillWidth
        )
        BackArrowButton(
            navController = navController,
            color = Color.White,
            modifier = Modifier.align(Alignment.TopStart)
        )
    }
}