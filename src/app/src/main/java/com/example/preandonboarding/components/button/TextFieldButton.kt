package com.example.preandonboarding.components.button

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.preandonboarding.R


@Composable
fun TextFieldButton(onclick: () -> Unit, modifier: Modifier = Modifier) {
    IconButton(
        onClick = { onclick() },
        modifier = modifier
        ) {
        Icon(
            imageVector = Icons.Default.ArrowForward,
            contentDescription = stringResource(id = R.string.contentDescription_arrow_forward),
            modifier = Modifier.size(40.dp)
        )
    }
}