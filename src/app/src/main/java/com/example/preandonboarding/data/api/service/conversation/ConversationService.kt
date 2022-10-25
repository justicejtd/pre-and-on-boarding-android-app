package com.example.preandonboarding.data.api.service.conversation

import com.example.preandonboarding.data.api.service.authentication.ACCEPT_APPLICATION_JSON_TYPE
import com.example.preandonboarding.data.model.conversation.Conversation
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

private const val CONVERSATION_URL = "conversations"

interface ConversationService {

    @Headers(ACCEPT_APPLICATION_JSON_TYPE)
    @GET(CONVERSATION_URL)
    suspend fun getConversations(): Response<List<Conversation>>
}