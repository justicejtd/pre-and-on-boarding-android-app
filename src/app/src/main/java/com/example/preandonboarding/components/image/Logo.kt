package com.example.preandonboarding.components.image

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Logo(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.size(35.dp)
    ) {
        NetworkImage(url = com.example.preandonboarding.utils.handlers.theme.Logo.url)
    }
}