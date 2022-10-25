package com.example.preandonboarding.ui.login.state

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

private const val PASSWORD_ERROR_MSG = "Empty password"

class PasswordState : TextFieldState(
    validator = { password -> isPasswordValid(password) },
    errorMessage = { PASSWORD_ERROR_MSG }
) {
    var isVisible by mutableStateOf(false)

    fun onShowPassword() {
        isVisible = !isVisible
    }
}

private fun isPasswordValid(password: String): Boolean {
    return password.isNotEmpty()
}