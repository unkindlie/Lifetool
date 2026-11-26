package com.litekreu.lifetool.data.repo

import com.litekreu.lifetool.data.dto.messages.SavedMessageCreateDto
import com.litekreu.lifetool.data.dto.messages.SavedMessageUpdateDto
import com.litekreu.lifetool.data.entities.SavedMessageEntity
import kotlinx.coroutines.flow.Flow

interface SavedMessageRepository {
    fun getMessagesBatch(batchNum: Int): Flow<List<SavedMessageEntity>>
    fun createMessage(input: SavedMessageCreateDto)
    fun updateMessage(input: SavedMessageUpdateDto)
    fun removeMessage(id: Int)
}