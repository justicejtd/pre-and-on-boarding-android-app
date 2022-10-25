package com.example.preandonboarding.components.loading

import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.preandonboarding.R

@Composable
fun TypingAnimation(modifier: Modifier = Modifier) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.typing))
    LottieAnimation(
        composition = composition,
        iterations = Integer.MAX_VALUE,
        speed = 2f,
        contentScale = ContentScale.FillWidth,
        alignment = Alignment.CenterStart,
        modifier = modifier.offset((-11).dp, (-7).dp)
    )
}