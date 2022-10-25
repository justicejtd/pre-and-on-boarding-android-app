package com.example.preandonboarding.ui.appSwitcher

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.preandonboarding.data.api.service.ApiClientService
import com.example.preandonboarding.data.api.service.authentication.AuthRepoImpl
import com.example.preandonboarding.ui.login.LoginViewModel
import com.example.preandonboarding.ui.login.LoginVmFactory
import com.example.preandonboarding.data.model.user.User
import com.example.preandonboarding.utils.navigation.Screen
import com.example.preandonboarding.utils.sharedPreference.AccessTokenSharedPref
import com.example.preandonboarding.utils.sharedPreference.UserSharedPref


@Composable
fun ApplicationSwitcher(
    loginViewModel: LoginViewModel = viewModel(
        factory = LoginVmFactory(
            AuthRepoImpl(
                authService = ApiClientService.getAuthService(),
                userSharedPref = UserSharedPref(LocalContext.current.applicationContext),
                accessTokenSharedPref = AccessTokenSharedPref(LocalContext.current)
            )
        )
    ), navController: NavHostController
) {

    if (User.isUserLoggedIn) {
        LaunchedEffect(Unit) {
            navController.navigate(Screen.AppIntro.route) {
                popUpTo(route = Screen.ApplicationSwitcher.route) {
                    inclusive = true
                }
            }
        }
    } else {
        LaunchedEffect(Unit) {
            navController.navigate(Screen.Login.route) {
                popUpTo(route = Screen.ApplicationSwitcher.route) {
                    inclusive = true
                }
            }
        }
    }
}