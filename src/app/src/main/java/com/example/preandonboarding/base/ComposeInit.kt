package com.example.preandonboarding.base


interface ComposeInit {
    fun initializeCompose()

    interface Provider {
        fun get(): ComposeInit
    }
}