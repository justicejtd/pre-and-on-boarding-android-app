package com.example.preandonboarding.base

import androidx.compose.runtime.Composable


interface ComposeMediator {
    fun mapComposeArgs()

    @Composable
    fun Render(any: Any)
}