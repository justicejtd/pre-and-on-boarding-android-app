package com.example.preandonboarding.components.wheelSpinner

import androidx.compose.runtime.*
import com.example.preandonboarding.data.model.blockItem.wheelSpinner.WheelSpinner
import com.example.preandonboarding.data.model.user.User
import kotlin.math.floor

private const val WHEEL_SPINNER_DEFAULT_TEXT = "Spin the wheel"

class WheelSpinnerState(val wheelSpinner: WheelSpinner) {
    val spinDuration: Int = 5000
    private var _selectedUser: User? = null

    /**
     * Keeps track on the play button visibility.
     */
    var isPlayButtonEnabled by mutableStateOf(true)
        private set

    /**
     * Keeps track of the wheel angle target after each spin.
     */
    var angleTarget by mutableStateOf(0)
        private set

    /**
     * Keeps track of the user that has been found after playing the wheel spinner.
     */
    var selectedUser by mutableStateOf<User?>(null)
        private set

    /**
     * Shows msg text from the block item or default value (Spin the wheel)
     */
    val text = { wheelSpinner.msgText.ifEmpty { WHEEL_SPINNER_DEFAULT_TEXT } }

    fun onSpinClick() {
        isPlayButtonEnabled = false

        startSpinner()
    }

    var trackerCount = 0

    private fun startSpinner() {
        // Final point of rotation defined right here
        angleTarget = floor(Math.random() * 36000).toInt()// random : 0-360
        trackerCount += angleTarget
        val numOfPrizes = wheelSpinner.users.size // quantity of prize
        val degreesPerPrize = 360.0 / numOfPrizes // size of sector per prize in degrees
        val index = floor((Math.floorMod(trackerCount, 360) / degreesPerPrize))

        _selectedUser = wheelSpinner.users[index.toInt()]
    }

    fun onFinished() {
        selectedUser = _selectedUser
        isPlayButtonEnabled = true
    }

    fun onPopupClose() {
        selectedUser = null
    }
}

@Composable
fun rememberWheelSpinnerState(wheelSpinner: WheelSpinner) =
    remember { WheelSpinnerState(wheelSpinner) }
