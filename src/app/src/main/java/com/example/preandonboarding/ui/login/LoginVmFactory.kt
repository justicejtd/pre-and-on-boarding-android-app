package com.example.preandonboarding.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.preandonboarding.data.api.service.authentication.AuthRepoImpl
import com.example.preandonboarding.utils.constants.FactoryConstants.FACTORY_EXCEPTION_MSG
import java.lang.IllegalArgumentException

/**
 * Handles the initialization for LoginViewModel
 * @param repository is the authentication repo.
 */
class LoginVmFactory(private val repository: AuthRepoImpl) :
    ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(repository) as T
        }
        throw IllegalArgumentException(FACTORY_EXCEPTION_MSG)
    }
}