package com.example.blockitemcomponents.components.textBlockItem

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.example.preandonboarding.R
import com.example.preandonboarding.components.text.BodyMediumText

@Composable
fun TextBlockItem(msgText: String) {
    BodyMediumText(
        text = msgText,
        modifier = Modifier.padding(dimensionResource(id = R.dimen.space_padding_small))
    )
}
