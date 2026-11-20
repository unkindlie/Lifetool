package com.litekreu.lifetool.domain.state

import com.litekreu.lifetool.data.entities.SavedMessageEntity

data class SavedMessagesState (
    val messages: List<SavedMessageEntity> = listOf()
)