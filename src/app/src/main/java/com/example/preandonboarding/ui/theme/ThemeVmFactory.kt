package com.example.preandonboarding.ui.theme

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.preandonboarding.data.api.service.theme.ThemeRepo
import com.example.preandonboarding.utils.constants.FactoryConstants.FACTORY_EXCEPTION_MSG
import java.lang.IllegalArgumentException

class ThemeVmFactory(private val themeRepo: ThemeRepo) :
    ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ThemeViewModel::class.java)) {
            return ThemeViewModel(themeRepo) as T
        }
        throw IllegalArgumentException(FACTORY_EXCEPTION_MSG)
    }
}