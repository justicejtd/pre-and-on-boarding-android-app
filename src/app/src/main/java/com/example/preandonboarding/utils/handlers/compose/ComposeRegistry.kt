package com.example.preandonboarding.utils.handlers.compose

import com.example.preandonboarding.base.ComposeMediator


object ComposeRegistry {
    private val composeFunctions: HashMap<String, ComposeMediator> =
        hashMapOf()

    fun registerComposable(key: String, mediator: ComposeMediator) {
        composeFunctions[key] = mediator
    }

    fun getComposable(composeType: String): ComposeMediator? {
        return composeFunctions[composeType]
    }
}
