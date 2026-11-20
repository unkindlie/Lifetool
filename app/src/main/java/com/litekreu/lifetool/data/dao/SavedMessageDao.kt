package com.litekreu.lifetool.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.litekreu.lifetool.data.entities.SavedMessageEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SavedMessageDao {
    @Query("SELECT * FROM saved_messages ORDER BY id DESC LIMIT :batchNum")
    fun getMessagesBatch(batchNum: Int): Flow<List<SavedMessageEntity>>

    @Query("INSERT INTO saved_messages(text) VALUES (:messageText)")
    fun createdMessage(messageText: String)

    @Query("DELETE FROM saved_messages WHERE id = :id")
    fun removeMessage(id: Int)
}