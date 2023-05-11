package com.asmaa.news.core.dp.articles

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.asmaa.news.core.dp.Converters
import com.asmaa.news.core.models.ArticlesItem



@Database( entities = [ArticlesItem::class] , version = 1 )
@TypeConverters( Converters::class )

abstract class ArticlesDataBase: RoomDatabase() {

    abstract fun getArticlesDao(): ArticlesDao

    companion object{

        @Volatile
        private var instance: ArticlesDataBase?= null

        private var LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: createDataBase(context).also { instance = it }
        }

        private fun createDataBase(context: Context) =
            Room.databaseBuilder(
            context.applicationContext,
            ArticlesDataBase::class.java,
           "article_dp.dp"
            ).build()
    }
}