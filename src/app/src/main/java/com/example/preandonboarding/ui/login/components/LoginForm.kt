package com.example.preandonboarding.ui.login.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.dimensionResource
import androidx.navigation.NavHostController
import com.example.preandonboarding.R
import com.example.preandonboarding.components.button.LoginButton
import com.example.preandonboarding.components.error.ErrorField
import com.example.preandonboarding.components.indicator.CustomCircleProgressIndicator
import com.example.preandonboarding.data.api.service.authentication.LoginResponse
import com.example.preandonboarding.data.api.utils.Resource
import com.example.preandonboarding.data.api.utils.Status
import com.example.preandonboarding.ui.login.state.EmailState
import com.example.preandonboarding.ui.login.state.PasswordState
import com.example.preandonboarding.utils.navigation.Screen


/**
 * Column for containing login input fields and button.
 */
@Composable
fun LoginForm(
    emailState: EmailState,
    passwordState: PasswordState,
    navController: NavHostController,
    onLogin: () -> Unit,
    loginResponse: Resource<LoginResponse>?,
    modifier: Modifier = Modifier
) {
    val localFocusManager = LocalFocusManager.current
    val isCredentialsValid = emailState.isValid() && passwordState.isValid()

    Column(
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.space_padding_small)),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        EmailInputField(
            emailState = emailState,
            onImeAction = {
                emailState.validate()
                localFocusManager.moveFocus(FocusDirection.Next) }
        )
        PasswordInputField(
            passwordState = passwordState,
            onImeAction = {
                localFocusManager.clearFocus()
                passwordState.validate()
                if (isCredentialsValid) onLogin()
            })
        // Login status
        loginResponse?.let {
            when (it.status) {
                Status.SUCCESS -> {
                    LaunchedEffect(Unit) {
                        navController.navigate(Screen.AppIntro.route) {
                            popUpTo(Screen.Login.route) { inclusive = true }
                        }
                    }
                }
                // If their request is loading show circular progress indicator
                Status.LOADING -> {
                    CustomCircleProgressIndicator()
                }

                // If their is an error show message
                Status.ERROR -> {
                    it.message?.let { it1 -> ErrorField(error = it1) }
                }
            }
        }
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.space_padding_large)))
        LoginButton(onClick = onLogin, enabled = isCredentialsValid)
    }
}