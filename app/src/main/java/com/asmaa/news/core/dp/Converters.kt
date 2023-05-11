package com.asmaa.news.core.dp

import androidx.room.TypeConverter
import com.asmaa.news.core.payloads.Source

class Converters {

    @TypeConverter
    fun fromSource(source: Source): String? {
        return source.name
    }

    @TypeConverter
    fun toSource(name: String): Source {
        return Source(name , name)
    }
}