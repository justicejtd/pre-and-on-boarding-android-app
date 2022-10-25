package com.example.preandonboarding.components.button

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.preandonboarding.R
import com.example.preandonboarding.ui.theme.DefaultShapes

/**
 * A button with an arrow icon inside, the default size is 40dp.
 * @param onClick for onclick event.
 * @param modifier
 */
@Composable
fun RightArrowButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val size = dimensionResource(id = R.dimen.button_size)

    Button(
        onClick = onClick,
        shape = DefaultShapes.large,
        contentPadding = PaddingValues(0.dp),
        modifier = modifier.size(size)
    ) {
        Icon(
            Icons.Default.ArrowForward,
            contentDescription = stringResource(id = R.string.contentDescription_arrow_forward),
            modifier = Modifier.size(size),
        )
    }
}
