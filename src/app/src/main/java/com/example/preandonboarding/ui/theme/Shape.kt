package com.example.preandonboarding.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.ui.unit.dp

val DefaultShapes = Shapes(
    small = RoundedCornerShape(4.dp),
    medium = RoundedCornerShape(8.dp),
    large = RoundedCornerShape(12.dp)
)

val ProfileImageShapes = Shapes(
    small = RoundedCornerShape(0.dp, 0.dp, 8.dp, 8.dp),
    medium = RoundedCornerShape(0.dp, 0.dp, 16.dp, 16.dp),
    large = RoundedCornerShape(0.dp, 0.dp, 32.dp, 32.dp)
)

val ChatBubbleShapes = Shapes(
    small = RoundedCornerShape(4.dp, 20.dp, 20.dp, 20.dp),
    medium = RoundedCornerShape(8.dp, 20.dp, 20.dp, 20.dp),
    large = RoundedCornerShape(12.dp, 20.dp, 20.dp, 20.dp)
)

val ChatBubbleReplyShapes = Shapes(
    small = RoundedCornerShape(20.dp, 4.dp, 20.dp, 20.dp),
    medium = RoundedCornerShape(20.dp, 8.dp, 20.dp, 20.dp),
    large = RoundedCornerShape(20.dp, 12.dp, 20.dp, 20.dp)
)