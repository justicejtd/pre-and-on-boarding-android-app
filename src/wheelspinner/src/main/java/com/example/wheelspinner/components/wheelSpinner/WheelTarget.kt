package com.example.wheelspinner.components.wheelSpinner

import androidx.compose.foundation.Image
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.wheelspinner.R

@Composable
fun WheelTarget(modifier: Modifier = Modifier, color: Color = MaterialTheme.colorScheme.primary) {
    Image(
        painter = painterResource(id = R.drawable.target),
        contentDescription = stringResource(id = R.string.contentDescription_wheel_target),
        colorFilter = ColorFilter.tint(color = color),
        modifier = modifier
    )
}