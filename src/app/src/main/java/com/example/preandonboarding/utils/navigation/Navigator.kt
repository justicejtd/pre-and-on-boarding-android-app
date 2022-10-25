package com.example.preandonboarding.utils.navigation

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

object Navigator {

    private val navigateFlowMutable =
        MutableSharedFlow<NavViewModel<NavigationType>>(extraBufferCapacity = 1)
    val navigateFlow = navigateFlowMutable.asSharedFlow()

    /**
     * Used to navigate to a specific screen.
     * @param screen Destination screen.
     */
    fun navigateTo(screen: Screen) {
        navigateFlowMutable.tryEmit(NavViewModel.navigateTo(screen = screen))
    }

    /**
     * Used to navigate to a specific and to pop back stacked screens.
     * @param screen Destination screen.
     * @param popUpTo Pop all screens up to the popUpTo screen.
     * @param inclusive If value is true then popUpTo screen will also be popped.
     */
    fun navigatePopUpTo(screen: Screen, popUpTo: Screen, inclusive: Boolean = false) {
        navigateFlowMutable.tryEmit(
            NavViewModel.navigatePopUpTo(
                screen = screen,
                popUpTo = popUpTo,
                inclusive = inclusive
            )
        )
    }

}