package com.example.preandonboarding.components.message

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.example.preandonboarding.R
import com.example.preandonboarding.ui.theme.ChatBubbleReplyShapes
import com.example.preandonboarding.ui.theme.ChatBubbleShapes

/**
 * Handles and shows the conversation message types.
 * These types could be a video, image, gif or text.
 * @param modifier
 * @param content
 */
@Composable
fun MessageCard(
    isReply: Boolean,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    val configuration = LocalConfiguration.current
    val maxWidth = configuration.screenWidthDp * 0.70
    var color = MaterialTheme.colorScheme.surface
    var shape = ChatBubbleShapes.small

    if(isReply) {
        color = MaterialTheme.colorScheme.secondaryContainer
        shape = ChatBubbleReplyShapes.small
    }

    Surface(
        shadowElevation = 2.dp,
        color = color,
        shape = shape,
        modifier = modifier
            .padding(end = dimensionResource(id = R.dimen.space_padding_medium))
            .widthIn(max = maxWidth.dp)
    ) {
        Column {
            content()
        }
    }
}