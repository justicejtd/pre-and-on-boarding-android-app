package com.example.preandonboarding.ui.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.TopAppBar
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.preandonboarding.R
import com.example.preandonboarding.components.header.Header
import com.example.preandonboarding.components.indicator.CustomCircleProgressIndicator
import com.example.preandonboarding.components.menu.OverflowMenu
import com.example.preandonboarding.data.api.service.ApiClientService
import com.example.preandonboarding.data.api.service.authentication.AuthRepoImpl
import com.example.preandonboarding.data.api.service.conversation.ConversationRepoImpl
import com.example.preandonboarding.ui.dashboard.component.DashboardItemList
import com.example.preandonboarding.ui.theme.DefaultStatusBarColor
import com.example.preandonboarding.utils.navigation.Screen
import com.example.preandonboarding.utils.sharedPreference.AccessTokenSharedPref
import com.example.preandonboarding.utils.sharedPreference.UserSharedPref

@Composable
fun DashboardPage(
    navController: NavController = rememberNavController(),
    dashboardViewModel: DashboardViewModel = viewModel(
        factory = DashboardVmFactory(
            conversationRepo = ConversationRepoImpl(
                conversationService = ApiClientService.getConversationService()
            ),
            authRepo = AuthRepoImpl(
                authService = ApiClientService.getAuthService(),
                userSharedPref = UserSharedPref(LocalContext.current.applicationContext),
                accessTokenSharedPref = AccessTokenSharedPref(LocalContext.current)
            )
        )
    )
) {

    val screenPadding = dimensionResource(id = R.dimen.screen_padding)
    DefaultStatusBarColor(
        systemBarsColor = MaterialTheme.colorScheme.tertiaryContainer,
        onSystemBarsColor = MaterialTheme.colorScheme.onTertiaryContainer
    )

    if (dashboardViewModel.isUserLoggedOut) {
        LaunchedEffect(Unit) {
            navController.navigate(Screen.Login.route) {
                popUpTo(route = Screen.Dashboard.route) {
                    inclusive = true
                }
            }
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Header(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.tertiaryContainer)
                .align(Alignment.TopCenter)
        ) {
            TopAppBar(
                title = { Text(text = "") },
                actions = {
                    OverflowMenu {
                        DropdownMenuItem(
                            onClick = { dashboardViewModel.onLogout() },
                            text = {
                                Text(
                                    stringResource(id = R.string.logout),
                                    style = MaterialTheme.typography.labelMedium,
                                )
                            }
                        )
                    }
                },
                elevation = 0.dp,
                backgroundColor = Color.Transparent,
            )
        }
        Column(
            Modifier
                .align(Alignment.TopCenter)
                .fillMaxWidth()
                .padding(start = screenPadding, end = screenPadding, bottom = screenPadding)
        ) {
            Spacer(modifier = Modifier.height(54.dp))
            Text(
                text = "Hello,\nJustice Dreischor✌",
                style = MaterialTheme.typography.displaySmall.copy(
                    fontWeight = FontWeight.ExtraBold
                ),
                color = MaterialTheme.colorScheme.onTertiaryContainer
            )
            Column {

                if (dashboardViewModel.isConversationLoading) {
                    CustomCircleProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
                }
                DashboardItemList(
                    conversations = dashboardViewModel.conversations,
                    navController = navController
                )
            }
        }
    }
}
