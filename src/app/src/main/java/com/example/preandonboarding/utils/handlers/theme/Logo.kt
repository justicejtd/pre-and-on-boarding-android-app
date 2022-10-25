package com.example.preandonboarding.utils.handlers.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

private const val IMAGE_PLACEHOLDER_URL =
    "https://firebasestorage.googleapis.com/v0/b/pre-and-onboarding-app.appspot.com/o/placeholder.png?alt=media&token=b191ac2e-83f1-445a-b0ea-a6318576853d"

object Logo {
    var url by mutableStateOf(IMAGE_PLACEHOLDER_URL)
        private set

    fun setLogo(url: String?) {
        if (url != null) {
            if (url.isNotEmpty()) {
                this.url = url
            }
        }
    }
}