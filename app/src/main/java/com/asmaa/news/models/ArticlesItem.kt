package com.asmaa.news.models

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
@Entity( tableName = "articles")
data class ArticlesItem(

    @PrimaryKey( autoGenerate = true )
    @ColumnInfo
    var id: Int?=null,

    @ColumnInfo
    @field:SerializedName("publishedAt")
    val publishedAt: String? = null,

    @ColumnInfo
    @field:SerializedName("author")
    val author: String? = null,

    @ColumnInfo
    @field:SerializedName("urlToImage")
    val urlToImage: String? = null,

    @ColumnInfo
    @field:SerializedName("description")
    val description: String? = null,

    @ColumnInfo
    @field:SerializedName("source")
    val source: Source? = null,

    @ColumnInfo
    @field:SerializedName("title")
    val title: String? = null,

    @ColumnInfo
    @field:SerializedName("url")
    val url: String? = null,

    @ColumnInfo
    @field:SerializedName("content")
    val content: String? = null

) : Parcelable
