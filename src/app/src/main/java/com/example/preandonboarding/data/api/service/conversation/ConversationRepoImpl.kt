package com.example.preandonboarding.data.api.service.conversation

import com.example.preandonboarding.data.model.conversation.Conversation
import retrofit2.Response


class ConversationRepoImpl(private val conversationService: ConversationService) : ConversationRepo {
    override suspend fun getConversations(): Response<List<Conversation>> = conversationService.getConversations()
}