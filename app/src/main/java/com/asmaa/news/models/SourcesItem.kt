package com.asmaa.news.models

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class SourcesItem(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    @field:SerializedName("id")
    val id: Int? = null,

    @ColumnInfo
    @field:SerializedName("country")
    val country: String? = null,

    @ColumnInfo

    @field:SerializedName("name")
    val name: String? = null,

    @ColumnInfo

    @field:SerializedName("description")
    val description: String? = null,

    @ColumnInfo
    @field:SerializedName("language")
    val language: String? = null,


    @ColumnInfo
    @field:SerializedName("category")
    val category: String? = null,

    @ColumnInfo
    @field:SerializedName("url")
    val url: String? = null

) : Parcelable

