package com.example.preandonboarding.utils.exceptions

import kotlinx.coroutines.CoroutineExceptionHandler

/**
 * Used to handle any exception when using coroutine.
 */
object CoroutineException {

    /**
     * Exception will be printed using printStackTrace.
     */
    val handler = CoroutineExceptionHandler { _, exception ->
        exception.printStackTrace()
    }
}