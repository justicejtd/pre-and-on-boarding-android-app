package com.example.preandonboarding.components.button

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.preandonboarding.ui.theme.DefaultShapes

@Composable
fun LargeOutlinedButton(
    text: String,
    modifier: Modifier = Modifier,
    icon: ImageVector?,
    contentDescription: String? = null,
    onClick: () -> Unit
) {
    OutlinedButton(
        onClick = { onClick() },
        shape = DefaultShapes.large,
        modifier = modifier
    ) {
        if (icon != null) {
            Icon(
                imageVector = icon,
                tint = MaterialTheme.colorScheme.onSecondaryContainer,
                contentDescription = contentDescription,
                modifier = Modifier.padding(end = ButtonDefaults.IconSpacing)
            )
        }
        Text(text)
    }
}