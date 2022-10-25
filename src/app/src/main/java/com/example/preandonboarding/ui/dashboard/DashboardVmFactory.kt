package com.example.preandonboarding.ui.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.preandonboarding.data.api.service.authentication.AuthRepo
import com.example.preandonboarding.data.api.service.conversation.ConversationRepo
import com.example.preandonboarding.utils.constants.FactoryConstants.FACTORY_EXCEPTION_MSG
import java.lang.IllegalArgumentException


/**
 * Handles the initialization for DashboardViewModel.
 * @param conversationRepo - conversation repository.
 */
class DashboardVmFactory(
    private val conversationRepo: ConversationRepo,
    private val authRepo: AuthRepo
) :
    ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DashboardViewModel::class.java)) {
            return DashboardViewModel(conversationRepo = conversationRepo, authRepo = authRepo) as T
        }
        throw IllegalArgumentException(FACTORY_EXCEPTION_MSG)
    }
}