package com.asmaa.news.core.dp.sources

import android.content.Context
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Room
import androidx.room.RoomDatabase
import com.asmaa.news.core.dp.articles.ArticlesDataBase
import com.asmaa.news.core.models.SourcesItem

@Database(entities = [SourcesItem::class], version = 1 , exportSchema = false)
abstract class SourcesDataBase : RoomDatabase() {

    abstract fun SourcesDao(): SourcesDao

    companion object {
        var dataBase: SourcesDataBase? = null

         fun init(context: Context){

            if (dataBase == null) {
                dataBase =
                    Room.databaseBuilder(context, SourcesDataBase::class.java, "newsdatabase")
                        .fallbackToDestructiveMigration()
                        .build()
            }

        }

        fun getInstance():SourcesDataBase{
            return dataBase!!

        }

    }
}