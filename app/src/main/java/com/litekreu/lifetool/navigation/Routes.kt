package com.litekreu.lifetool.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed interface Routes {
    @Serializable
    data object Days
    @Serializable
    data class DayDetailed(
        val dayId: Int
    ): Routes
}