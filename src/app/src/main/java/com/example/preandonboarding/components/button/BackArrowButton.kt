package com.example.preandonboarding.components.button

import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.preandonboarding.R

@Composable
fun BackArrowButton(
    navController: NavController,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified
) {
    IconButton(
        onClick = { navController.navigateUp() },
        modifier = modifier
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = stringResource(id = R.string.contentDescription_arrow_backward),
            modifier = Modifier.size(30.dp),
            tint = color
        )
    }
}
