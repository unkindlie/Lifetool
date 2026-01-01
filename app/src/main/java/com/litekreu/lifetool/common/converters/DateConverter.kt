package com.litekreu.lifetool.common.converters

import android.annotation.SuppressLint
import androidx.room.TypeConverter
import java.time.LocalDateTime

class DateConverter {
    @SuppressLint("NewApi")
    @TypeConverter
    fun fromTimestamp(value: String?): LocalDateTime? {
        return value?.let { LocalDateTime.parse(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: LocalDateTime?): String? {
        return date?.toString()
    }
}