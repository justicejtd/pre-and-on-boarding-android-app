package com.example.preandonboarding.data.api.utils

/**
 * Network call states: SUCCESS, ERROR, LOADING.
 * SUCCESS can be used when network call has been executed successfully.
 * ERROR can be used when network call has been executed unsuccessfully.
 * LOADING can be used when network call is in the loading state.
 */
enum class Status {
    /**
     * SUCCESS can be used when network call has been executed successfully.
     */
    SUCCESS,

    /**
     * ERROR can be used when network call has been executed unsuccessfully.
     */
    ERROR,

    /**
     * LOADING can be used when network call is in the loading state.
     */
    LOADING
}