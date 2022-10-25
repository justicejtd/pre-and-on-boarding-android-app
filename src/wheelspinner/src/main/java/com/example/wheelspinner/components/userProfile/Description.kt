package com.example.wheelspinner.components.userProfile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.example.wheelspinner.R

@Composable
fun Description(text: String) {
    Column(horizontalAlignment = Alignment.Start) {
        Text(
            text = stringResource(id = R.string.label_description),
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(Modifier.height(dimensionResource(id = com.example.preandonboarding.R.dimen.space_padding_small)))
        Text(text = text, style = MaterialTheme.typography.bodyMedium)
    }
}