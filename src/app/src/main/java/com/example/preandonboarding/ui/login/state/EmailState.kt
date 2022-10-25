package com.example.preandonboarding.ui.login.state

private const val EMAIL_ERROR_MSG = "Invalid email"
private const val EMAIL_REGEX = "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})"


class EmailState: TextFieldState(
    validator = { email -> isEmailValid(email) },
    errorMessage = { EMAIL_ERROR_MSG }
)

private fun isEmailValid(email: String): Boolean {
    return email.isNotEmpty() && EMAIL_REGEX.toRegex().matches(email)
}