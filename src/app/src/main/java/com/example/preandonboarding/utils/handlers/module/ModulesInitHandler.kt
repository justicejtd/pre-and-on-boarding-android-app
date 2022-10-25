package com.example.preandonboarding.utils.handlers.module

import com.example.preandonboarding.base.ComposeInit

private const val COMPOSE_INIT_SPINNER_WHEEL =
    "com.example.wheelspinner.ComposeInitImpl\$Provider"
private const val COMPOSE_INIT_BLOCK_ITEM_COMPONENTS =
    "com.example.blockitemcomponents.ComposeInitImpl\$Provider"

class ModulesInitHandler {

    fun initializeCompose() {
        (Class.forName(COMPOSE_INIT_SPINNER_WHEEL).kotlin.objectInstance as ComposeInit.Provider).get()
            .initializeCompose()
        (Class.forName(COMPOSE_INIT_BLOCK_ITEM_COMPONENTS).kotlin.objectInstance as ComposeInit.Provider).get()
            .initializeCompose()
    }
}