package com.litekreu.lifetool.data.repo.impl

import com.litekreu.lifetool.data.dao.SavedMessageDao
import com.litekreu.lifetool.data.dto.messages.SavedMessageCreateDto
import com.litekreu.lifetool.data.dto.messages.SavedMessageUpdateDto
import com.litekreu.lifetool.data.entities.SavedMessageEntity
import com.litekreu.lifetool.data.repo.SavedMessageRepository
import kotlinx.coroutines.flow.Flow

class SavedMessageRepositoryImpl(
    private val savedMessageDao: SavedMessageDao
): SavedMessageRepository {
    override fun getMessagesBatch(batchNum: Int): Flow<List<SavedMessageEntity>> =
        savedMessageDao.getMessagesBatch(batchNum)

    override fun createMessage(input: SavedMessageCreateDto) {
        savedMessageDao.createdMessage(
            text = input.text,
            createdAt = input.createdAt
        )
    }

    override fun updateMessage(input: SavedMessageUpdateDto) {
        savedMessageDao.updateMessage(
            id = input.id,
            text = input.text,
            updatedAt = input.updatedAt
        )
    }

    override fun removeMessage(id: Int) {
        savedMessageDao.removeMessage(id)
    }
}