package com.example.preandonboarding.data.api.service.conversation

import com.example.preandonboarding.data.model.conversation.Conversation
import retrofit2.Response

interface ConversationRepo {

    /**
     * Returns a response with list of conversation configuration names.
     * @return Response<List<Conversation>>
     */
    suspend fun getConversations(): Response<List<Conversation>>
}