package com.asmaa.news.core.dp.articles

import androidx.lifecycle.LiveData
import androidx.room.*
import com.asmaa.news.core.models.ArticlesItem


@Dao
interface ArticlesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upSert( artical: ArticlesItem): Long

    @Query("SELECT * FROM articles")
    fun getAllArticles(): LiveData<List<ArticlesItem>>

    @Delete
    fun deleteArticle( artical: ArticlesItem)

}