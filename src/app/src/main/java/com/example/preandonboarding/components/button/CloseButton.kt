package com.example.preandonboarding.components.button

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.example.preandonboarding.R

@Composable
fun CloseButton(onClick: () -> Unit, modifier: Modifier = Modifier, color: Color = Color.White) {
    IconButton(onClick = onClick, modifier = modifier) {
        Icon(
            imageVector = Icons.Default.Close,
            contentDescription = stringResource(id = R.string.contentDescription_close_icon),
            tint = color,
        )
    }
}