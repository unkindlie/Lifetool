package com.litekreu.lifetool.data.repo.impl

import com.litekreu.lifetool.data.dao.SavedMessageDao
import com.litekreu.lifetool.data.entities.SavedMessageEntity
import com.litekreu.lifetool.data.repo.SavedMessageRepository
import kotlinx.coroutines.flow.Flow

class SavedMessageRepositoryImpl(
    private val savedMessageDao: SavedMessageDao
): SavedMessageRepository {
    override fun getMessagesBatch(batchNum: Int): Flow<List<SavedMessageEntity>> =
        savedMessageDao.getMessagesBatch(batchNum)

    override fun createMessage(messageText: String) {
        savedMessageDao.createdMessage(messageText)
    }

    override fun removeMessage(id: Int) {
        savedMessageDao.removeMessage(id)
    }
}