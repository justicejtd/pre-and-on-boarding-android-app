package com.example.preandonboarding.ui.dashboard

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.preandonboarding.data.api.service.authentication.AuthRepo
import com.example.preandonboarding.data.api.service.conversation.ConversationRepo
import com.example.preandonboarding.data.model.conversation.Conversation
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DashboardViewModel(
    private val conversationRepo: ConversationRepo,
    private val authRepo: AuthRepo
) : ViewModel() {

    var conversations by mutableStateOf(listOf<Conversation>())
        private set

    var isConversationLoading by mutableStateOf(false)
        private set

    var isUserLoggedOut by mutableStateOf(false)
        private set

    init {
        loadConversations()
    }

    private fun loadConversations() {
        isConversationLoading = true
        viewModelScope.launch(Dispatchers.IO + CoroutineExceptionHandler { _, exception ->
            exception.printStackTrace()
            Log.e("Error", exception.message.toString())
            // ToDo handle error
        }
        ) {
            // Get conversations
            val response = conversationRepo.getConversations()

            if (response.isSuccessful) {
                // Update conversation list
                response.body()?.let { conversations = it }
                withContext(Dispatchers.Main) {
                    isConversationLoading = false
                }
            } else {
                Log.e("Error", response.body().toString())
                // ToDo handle unsuccessfully call
            }
        }
    }

    fun onLogout() {
        viewModelScope.launch(Dispatchers.IO + CoroutineExceptionHandler { _, exception ->
            exception.printStackTrace()
            Log.e("Error", exception.message.toString())
            // ToDo handle error
        }) {
            try {
                // Logout user from backend
                authRepo.logout()
            } finally {
                isUserLoggedOut = true
            }
        }
    }

//    private fun getSortedConversationSteps(steps: List<ConversationStep>): List<ConversationStep> {
//        // Sort message flow
//        steps.forEach { step ->
//            step.messages = step.messages.sortedBy { it.position }
//        }
//
//        // Sort step flow
//        return steps.sortedBy { it.position }
//    }
}