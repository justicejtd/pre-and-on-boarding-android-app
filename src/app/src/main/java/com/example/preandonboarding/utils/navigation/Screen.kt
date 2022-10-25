package com.example.preandonboarding.utils.navigation

// Routes names
private const val APPLICATION_SWITCHER_ROUTE = "applicationSwitcher"
private const val LOGIN_ROUTE = "login"
private const val APP_INTRO_ROUTE = "appIntro"
private const val DASHBOARD_ROUTE = "dashboard"
private const val CONVERSATION_BASE = "conversationBase"
private const val FULLSCREEN_IMAGE = "fullscreenImage"

/**
 * Holds all the routes.
 * @param route
 */
sealed class Screen(val route: String) {
    object ApplicationSwitcher : Screen(route = APPLICATION_SWITCHER_ROUTE)
    object Login : Screen(route = LOGIN_ROUTE)
    object AppIntro : Screen(route = APP_INTRO_ROUTE)
    object Dashboard : Screen(route = DASHBOARD_ROUTE)
    object ConversationBase : Screen(route = CONVERSATION_BASE)
    object FullScreenImage : Screen(route = FULLSCREEN_IMAGE)

    /**
     * Used for passing arguments between screens.
     * @param args
     */
    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/${arg}")
            }
        }
    }
}