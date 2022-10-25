package com.example.preandonboarding.data.api.utils

/**
 * Keeps track of network call status.
 */
data class Resource<out T>(val status: Status, val data: T?, val message: String?) {

    // Object for loading
    // Data class for success
    // Data class for error
    companion object {

        /**
         * Return Resource with status SUCCESS.
         */
        fun <T> success(data: T?): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        /**
         * Return Resource with status ERROR.
         */
        fun <T> error(msg: String, data: T?): Resource<T> {
            return Resource(Status.ERROR, data, msg)
        }

        /**
         * Return Resource with status LOADING.
         */
        fun <T> loading(data: T?): Resource<T> {
            return Resource(Status.LOADING, data, null)
        }

    }

}