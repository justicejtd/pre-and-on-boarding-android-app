package com.example.preandonboarding.utils.navigation

/**
 * Used to keep track of which navigation type is being used when using the NavViewModel.
 */
enum class NavigationType {
    /**
     * Navigate up a specific screen.
     */
    NAVIGATE_TO,

    /**
     * Navigate update to a screen and pop other screens from the backstack.
     */
    NAVIGATE_POP_UP_TO
}