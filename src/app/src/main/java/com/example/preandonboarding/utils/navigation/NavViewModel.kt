package com.example.preandonboarding.utils.navigation

/**
 * Navigator for navigating between screens in a viewModel.
 */
data class NavViewModel<out T>(
    val type: NavigationType,
    val screen: Screen,
    val popUpTo: Screen? = null,
    val inclusive: Boolean? = null
) {

    companion object {
        /**
         * Used to navigate to a screen.
         * @param screen Destination screen.
         * @return NavViewModel<T>
         */
        fun <T> navigateTo(screen: Screen): NavViewModel<T> {
            return NavViewModel(type = NavigationType.NAVIGATE_TO, screen = screen)
        }

        /**
         * Used to navigate to a screen and to pop other screens in the backstack.
         * You can also pop the popUpTo screen by setting the inclusive to true.
         * @param screen Destination screen.
         * @param popUpTo Pop all screens before this screen.
         * @param inclusive Pop the popUpTo screen along the other screens.
         */
        fun <T> navigatePopUpTo(
            screen: Screen,
            popUpTo: Screen,
            inclusive: Boolean
        ): NavViewModel<T> {
            return NavViewModel(
                type = NavigationType.NAVIGATE_POP_UP_TO,
                screen = screen,
                popUpTo = popUpTo,
                inclusive = inclusive
            )
        }
    }
}