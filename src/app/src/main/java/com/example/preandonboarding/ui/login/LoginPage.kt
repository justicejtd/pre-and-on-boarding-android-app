package com.example.preandonboarding.ui.login

import android.os.Build
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.preandonboarding.R
import com.example.preandonboarding.data.api.service.ApiClientService
import com.example.preandonboarding.data.api.service.authentication.AuthRepoImpl
import com.example.preandonboarding.ui.login.components.LoginForm
import com.example.preandonboarding.ui.login.components.LoginHeader
import com.example.preandonboarding.ui.login.state.EmailState
import com.example.preandonboarding.ui.login.state.PasswordState
import com.example.preandonboarding.utils.sharedPreference.AccessTokenSharedPref
import com.example.preandonboarding.utils.sharedPreference.UserSharedPref

private const val LOGIN_HEADER_ROW_WEIGHT = 1f
private const val LOGIN_FORM_COLUMN_WEIGHT = 2.5f

/**
 * Composable page for signing.
 * @param loginViewModel viewModel of Login page
 */
@Composable
fun LoginPage(
    loginViewModel: LoginViewModel =
        viewModel(
            factory = LoginVmFactory(
                AuthRepoImpl(
                    authService = ApiClientService.getAuthService(),
                    userSharedPref = UserSharedPref(LocalContext.current.applicationContext),
                    accessTokenSharedPref = AccessTokenSharedPref(LocalContext.current)
                )
            )
        ), navController: NavHostController
) {
    val emailState = remember { EmailState() }
    val passwordState = remember { PasswordState() }
    val loginResponse = loginViewModel.loginResponse.observeAsState()
    val configuration = LocalConfiguration.current

    Box(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
        Column(
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.screen_padding))
                .height(configuration.screenHeightDp.dp)
                .width(configuration.screenWidthDp.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LoginHeader(modifier = Modifier.weight(LOGIN_HEADER_ROW_WEIGHT))
            LoginForm(
                emailState = emailState,
                passwordState = passwordState,
                loginResponse = loginResponse.value,
                onLogin = {
                    loginViewModel.login(
                        email = emailState.text,
                        password = passwordState.text,
                        deviceName = Build.MODEL
                    )
                },
                navController = navController,
                modifier = Modifier.weight(LOGIN_FORM_COLUMN_WEIGHT)
            )
        }
    }
}