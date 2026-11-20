package com.litekreu.lifetool.data.repo

import com.litekreu.lifetool.data.dto.messages.SavedMessageCreateDto
import com.litekreu.lifetool.data.entities.SavedMessageEntity
import kotlinx.coroutines.flow.Flow

interface SavedMessageRepository {
    fun getMessagesBatch(batchNum: Int): Flow<List<SavedMessageEntity>>
    fun createMessage(input: SavedMessageCreateDto)
    fun removeMessage(id: Int)
}