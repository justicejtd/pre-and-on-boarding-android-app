package com.example.preandonboarding.ui.dashboard.component

import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.navigation.NavController
import com.example.preandonboarding.R
import com.example.preandonboarding.data.model.conversation.Conversation
import com.example.preandonboarding.utils.navigation.Screen
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

@Composable
fun DashboardItemList(
    conversations: List<Conversation>,
    modifier: Modifier = Modifier,
    navController: NavController
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(
            dimensionResource(id = R.dimen.space_padding_medium)
        ),
        contentPadding = PaddingValues(
            vertical = dimensionResource(id = R.dimen.space_padding_medium)
        ),
        modifier = modifier.fillMaxSize()
    ) {
        items(items = conversations) { conversation ->
            val mapper = jacksonObjectMapper()
            val json = mapper.writeValueAsString(conversation)
            val conversationArgument = Uri.encode(json)
            var progressPercentage = 0.85f
            var todo = "Introduction"

            if (conversations.indexOf(conversation) == 1) {
                progressPercentage = 0.0f
                todo = "Meet your colleagues"
            }

            DashboardItem(title = conversation.title, progressPercentage, todo = todo,
                onClick = { navController.navigate(route = Screen.ConversationBase.route.plus("/$conversationArgument")) })
        }
    }
}