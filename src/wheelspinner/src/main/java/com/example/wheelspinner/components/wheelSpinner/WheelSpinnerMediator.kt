package com.example.wheelspinner.components.wheelSpinner

import androidx.compose.runtime.Composable
import com.example.preandonboarding.base.ComposeMediator
import com.example.preandonboarding.components.wheelSpinner.rememberWheelSpinnerState
import com.example.preandonboarding.data.model.blockItem.MapBlockItemData
import com.example.preandonboarding.data.model.blockItem.wheelSpinner.WheelSpinner
import com.example.preandonboarding.utils.handlers.compose.ComposeRegistry
import com.example.preandonboarding.utils.constants.ComposeKeys

class WheelSpinnerMediator : ComposeMediator {
    override fun mapComposeArgs() {
        ComposeRegistry.registerComposable(ComposeKeys.WHEEL_SPINNER_BLOCK_ITEM, this)
    }

    @Composable
    override fun Render(any: Any) {
        if (any is MapBlockItemData) {
            val wheelSpinner = any.blockItem

            if (wheelSpinner is WheelSpinner) {
                val wheelSpinnerState = rememberWheelSpinnerState(wheelSpinner = wheelSpinner)
                WheelSpinner(wheelSpinnerState)
            }
        }
    }
}