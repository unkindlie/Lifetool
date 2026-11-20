package com.litekreu.lifetool.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.plus
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.litekreu.lifetool.data.dto.messages.SavedMessageCreateDto
import com.litekreu.lifetool.domain.viewmodel.SavedMessagesViewModel
import com.litekreu.lifetool.ui.common.LoadingWrapper
import com.litekreu.lifetool.ui.components.messages.MessageItem
import com.litekreu.lifetool.ui.components.messages.MessageTextField

@Composable
fun SavedScreen(
    modifier: Modifier,
    messagesViewModel: SavedMessagesViewModel = hiltViewModel()
) {
    val textState = rememberTextFieldState()
    val state by messagesViewModel.state.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            Text(text = "Saved", style = MaterialTheme.typography.headlineMedium)
        },
        bottomBar = {
            if (!state.isLoading) {
                MessageTextField(
                    textState = textState,
                    onAdd = {
                        messagesViewModel.addMessage(
                            SavedMessageCreateDto(
                                text = textState.text.trim().replace("[ \t]+".toRegex(), " ")
                            )
                        )
                        textState.edit { replace(0, length, "") }
                    },
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        },
        containerColor = MaterialTheme.colorScheme.surfaceContainer,
        modifier = modifier.padding(horizontal = 18.dp)
    ) { innerPadding ->
        Surface(
            color = MaterialTheme.colorScheme.surfaceContainer,
            modifier = Modifier.fillMaxSize()
                .padding(innerPadding.plus(PaddingValues(bottom = 4.dp))),
        ) {
            LoadingWrapper(
                isLoading = state.isLoading,
                error = state.error,
            ) {
                LazyColumn (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth().padding(top = 52.dp),
                    reverseLayout = true
                ) {
                    items(state.messages) { message ->
                        MessageItem(
                            message = message,
                            onRemove = { messagesViewModel.removeMessage(message.id) }
                        )
                    }
                }
            }
        }
    }
}