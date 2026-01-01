package com.litekreu.lifetool.features.note

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.litekreu.lifetool.features.note.classes.Note
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val repo: NoteRepository
) : ViewModel() {

    val notes =
        repo.getNotes().stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList())

    fun addNote(note: Note) {
        viewModelScope.launch { repo.insertNote(note) }
    }

    fun deleteNoteById(id: String) {
        viewModelScope.launch { repo.deleteNoteById(id) }
    }
}