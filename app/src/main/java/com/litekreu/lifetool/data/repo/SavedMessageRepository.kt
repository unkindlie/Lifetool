package com.litekreu.lifetool.data.repo

import com.litekreu.lifetool.data.entities.SavedMessageEntity
import kotlinx.coroutines.flow.Flow

interface SavedMessageRepository {
    fun getMessagesBatch(batchNum: Int): Flow<List<SavedMessageEntity>>
    fun createMessage(messageText: String)
    fun removeMessage(id: Int)
}