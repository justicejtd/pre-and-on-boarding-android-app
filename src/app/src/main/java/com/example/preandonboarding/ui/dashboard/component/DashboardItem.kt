@file:OptIn(
    ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class
)

package com.example.preandonboarding.ui.dashboard.component

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.preandonboarding.R
import com.example.preandonboarding.components.indicator.StaticCircularProgressIndicator
import com.example.preandonboarding.ui.theme.DefaultShapes

@Composable
fun DashboardItem(
    title: String,
    progressPercentage: Float,
    todo: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {

    Surface(
        shadowElevation = 2.dp,
        shape = DefaultShapes.medium,
        color = MaterialTheme.colorScheme.surface,
        modifier = modifier
            .fillMaxWidth()
            .height(150.dp),
        onClick = onClick
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .padding(dimensionResource(id = R.dimen.space_padding_medium))
        ) {
            Column {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                )
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.space_padding_extra_small)))
                Text(
                    text = stringResource(R.string.todo),
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.4f)
                    )
                )
                Text(
                    text = todo,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }

            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = dimensionResource(id = R.dimen.space_padding_large))
            ) {
                StaticCircularProgressIndicator(
                    progress = progressPercentage,
                    style = MaterialTheme.typography.labelMedium.copy(
                        fontSize = 22.sp,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                )
            }
        }
    }
}