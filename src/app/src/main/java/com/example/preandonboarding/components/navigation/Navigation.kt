package com.example.preandonboarding.components.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.preandonboarding.components.image.FullScreenImage
import com.example.preandonboarding.data.model.conversation.Conversation
import com.example.preandonboarding.ui.appIntro.AppIntroPage
import com.example.preandonboarding.ui.appSwitcher.ApplicationSwitcher
import com.example.preandonboarding.ui.conversationBase.ConversationBasePage
import com.example.preandonboarding.ui.conversationBase.ConversationBaseVmFactory
import com.example.preandonboarding.ui.dashboard.DashboardPage
import com.example.preandonboarding.ui.login.LoginPage
import com.example.preandonboarding.utils.handlers.block.BlockHandler
import com.example.preandonboarding.utils.navigation.NavigationType
import com.example.preandonboarding.utils.navigation.Navigator
import com.example.preandonboarding.utils.navigation.Screen
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

// Routes arguments names
private const val ROUTE_ARG_BASE_CONVERSATIONS = "conversation"
private const val ROUTE_ARG_FULLSCREEN_IMAGE_URL = "url"

/**
 * Screen destinations
 */
@Composable
fun Navigation(navController: NavHostController) {
    LaunchedEffect("navigation") {
        Navigator.navigateFlow.onEach {
            when (it.type) {
                NavigationType.NAVIGATE_TO -> {
                    navController.navigate(it.screen.route)
                }

                NavigationType.NAVIGATE_POP_UP_TO -> {
                    navController.navigate(it.screen.route) {
                        it.popUpTo?.let { it1 ->
                            popUpTo(route = it1.route) {
                                inclusive = it.inclusive == true
                            }
                        }
                    }
                }
            }
        }.launchIn(this)
    }

    NavHost(
        navController = navController,
        startDestination = Screen.ApplicationSwitcher.route,
        builder = {
            // Destination for ApplicationSwitcher
            composable(route = Screen.ApplicationSwitcher.route) {
                ApplicationSwitcher(navController = navController)
            }

            // Destination for Login page
            composable(route = Screen.Login.route) {
                LoginPage(navController = navController)
            }

            // Destination for AppIntro page
            composable(route = Screen.AppIntro.route) {
                AppIntroPage(navController = navController)
            }

            // Destination for Dashboard page
            composable(route = Screen.Dashboard.route) {
                DashboardPage(navController = navController)
            }

            // Destination for ConversationBase page

            composable(
                route = Screen.ConversationBase.route.plus("/{$ROUTE_ARG_BASE_CONVERSATIONS}"),
                arguments = listOf(navArgument(ROUTE_ARG_BASE_CONVERSATIONS) {
                    type = NavType.Companion.StringType
                })
            ) {

                val json = it.arguments?.getString(ROUTE_ARG_BASE_CONVERSATIONS)
                val conversation: Conversation = jacksonObjectMapper().readValue(json.toString())

                ConversationBasePage(conversation = conversation, navController = navController)
            }

            // Destination for Dashboard page
            composable(
                route = Screen.FullScreenImage.route.plus("/{$ROUTE_ARG_FULLSCREEN_IMAGE_URL}"),
                arguments = listOf(navArgument(ROUTE_ARG_FULLSCREEN_IMAGE_URL) {
                    type = NavType.Companion.StringType
                })
            ) {
                val url = it.arguments?.getString(ROUTE_ARG_FULLSCREEN_IMAGE_URL)
                FullScreenImage(navController = navController, url = url.toString())
            }
        }
    )
}