package com.example.wheelspinner.components.userProfile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.preandonboarding.ui.theme.DefaultShapes
import com.example.wheelspinner.R


@Composable
fun Hobbies(hobbies: List<String>) {
    val cellSize = 100.dp

    Column(horizontalAlignment = Alignment.Start) {
        Text(
            text = stringResource(id = R.string.label_hobbies),
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(Modifier.height(dimensionResource(id = com.example.preandonboarding.R.dimen.space_padding_small)))
        LazyVerticalGrid(
            columns = GridCells.Adaptive(cellSize),
            verticalArrangement = Arrangement.spacedBy(
                space = dimensionResource(id = com.example.preandonboarding.R.dimen.space_padding_extra_small)
            ),
            horizontalArrangement = Arrangement.spacedBy(
                space = dimensionResource(id = com.example.preandonboarding.R.dimen.space_padding_extra_small)
            ),
        ) {
            items(items = hobbies) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .clip(DefaultShapes.medium)
                        .background(MaterialTheme.colorScheme.primaryContainer)
                        .height(35.dp)
                ) {
                    Text(text = it, color = MaterialTheme.colorScheme.onPrimaryContainer)
                }
            }
        }
    }
}