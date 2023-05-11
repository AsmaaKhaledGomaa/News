package com.asmaa.news.core.dp.sources

import androidx.room.*
import com.asmaa.news.core.models.SourcesItem

@Dao
interface SourcesDao {

    @Query("SELECT * FROM SourcesItem")
    suspend fun getSources():List<SourcesItem?>

    @Query("select * from SourcesItem where category=:category")
    suspend fun getSourcesByCategory(category :String):List<SourcesItem>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upDateSources(sources:List<SourcesItem?>?)
}