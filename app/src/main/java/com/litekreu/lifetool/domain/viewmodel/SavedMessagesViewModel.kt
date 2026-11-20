package com.litekreu.lifetool.domain.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.litekreu.lifetool.data.repo.SavedMessageRepository
import com.litekreu.lifetool.domain.state.SavedMessagesState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SavedMessagesViewModel @Inject constructor(
    private val savedMessagesRepo: SavedMessageRepository
) : ViewModel() {
    private val _messages = savedMessagesRepo.getMessagesBatch(999)
        .onStart {
            _state.update {
                it.copy(
                    isLoading = true,
                    error = null,
                )
            }
        }
        .catch { ex ->
            _state.update {
                it.copy(
                    isLoading = false,
                    error = ex.message ?: "Failed to load messages"
                )
            }

            emit(emptyList())
        }
        .onEach {
            _state.update {
                it.copy(isLoading = false, error = null)
            }
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5_000),
            emptyList()
        )
    private val _state = MutableStateFlow(SavedMessagesState())

    val state = combine(_state, _messages) { state, messages ->
        state.copy(
            messages = messages
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), SavedMessagesState())

    fun addMessage(text: String) {
        CoroutineScope(Dispatchers.IO).launch {
            savedMessagesRepo.createMessage(text)
        }
    }
    fun removeMessage(id: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            savedMessagesRepo.removeMessage(id)
        }
    }
}