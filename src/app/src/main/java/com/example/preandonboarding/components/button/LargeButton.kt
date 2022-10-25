package com.example.preandonboarding.components.button

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.preandonboarding.ui.theme.DefaultShapes

/**
 * Large button is the main button that is used through out the whole application.
 * @param text is the label for the button.
 * @param onClick for onclick event.
 * @param icon for showing leading icon.
 * @param contentDescription is the icon description.
 */
@Composable
fun LargeButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    icon: ImageVector? = null,
    contentDescription: String? = null,
    isEnabled: Boolean = true,
) {
    Button(
        onClick = onClick,
        shape = DefaultShapes.large,
        enabled = isEnabled,
        modifier = modifier
    ) {
        if (icon != null) {
            Icon(
                imageVector = icon,
                tint = MaterialTheme.colorScheme.onPrimary,
                contentDescription = contentDescription,
                modifier = Modifier.padding(end = ButtonDefaults.IconSpacing)
            )
        }
        Text(text = text)
    }
}