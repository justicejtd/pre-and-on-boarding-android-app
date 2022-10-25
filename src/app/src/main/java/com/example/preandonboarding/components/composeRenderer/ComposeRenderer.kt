package com.example.preandonboarding.components.composeRenderer

import androidx.compose.runtime.*
import com.example.preandonboarding.utils.handlers.compose.ComposeRegistry

@Composable
fun ComposeRenderer(composeKey: String, any: Any) {
    ComposeRegistry.getComposable(composeKey)?.Render(any = any)
}

