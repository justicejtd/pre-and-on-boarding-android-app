package com.example.wheelspinner

import com.example.wheelspinner.components.wheelSpinner.WheelSpinnerMediator
import com.example.preandonboarding.base.ComposeInit
import com.example.preandonboarding.base.ComposeMediator

class ComposeInitImpl(private var mediators: List<ComposeMediator> = listOf()) : ComposeInit {

    init {
        mediators = listOf(WheelSpinnerMediator())
    }

    override fun initializeCompose() {
        mediators.forEach {
            it.mapComposeArgs()
        }
    }

    companion object Provider : ComposeInit.Provider {
        override fun get(): ComposeInit {
            return ComposeInitImpl()
        }

    }
}