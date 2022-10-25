package com.example.wheelspinner.components.wheelSpinner

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.example.wheelspinner.R

@Composable
fun PlayButton(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.primary,
    onClick: () -> Unit = {},
    isEnabled: Boolean = true
) {
    IconButton(onClick = onClick, modifier = modifier, enabled = isEnabled) {
        Icon(
            imageVector = Icons.Default.PlayCircle,
            contentDescription = stringResource(id = R.string.contentDescription_play_circle_icon),
            tint = color,
            modifier = Modifier.fillMaxSize()
        )
    }
}