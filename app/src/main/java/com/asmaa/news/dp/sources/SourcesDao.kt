package com.asmaa.news.dp.sources

import androidx.room.*
import com.asmaa.news.models.SourcesItem

@Dao
interface SourcesDao {

    @Query("SELECT * FROM SourcesItem")
    suspend fun getSources():List<SourcesItem?>

    @Query("select * from SourcesItem where category=:category")
    suspend fun getSourcesByCategory(category :String):List<SourcesItem>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upDateSources(sources:List<SourcesItem?>?)
}