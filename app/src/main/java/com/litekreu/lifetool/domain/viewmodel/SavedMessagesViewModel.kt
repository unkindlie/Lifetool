package com.litekreu.lifetool.domain.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.litekreu.lifetool.data.entities.SavedMessageEntity
import com.litekreu.lifetool.data.repo.SavedMessageRepository
import com.litekreu.lifetool.domain.state.SavedMessagesState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SavedMessagesViewModel @Inject constructor(
    private val savedMessagesRepo: SavedMessageRepository
) : ViewModel() {
    private val _messages = savedMessagesRepo.getMessagesBatch(999)
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), listOf())
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