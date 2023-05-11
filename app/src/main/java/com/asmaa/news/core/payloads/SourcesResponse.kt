package com.asmaa.news.core.payloads

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.asmaa.news.core.models.SourcesItem
import com.google.gson.annotations.SerializedName

@Parcelize
data class SourcesResponse(

    @field:SerializedName("sources")
    val sources: List<SourcesItem?>? = null,

    @field:SerializedName("status")
    val status: String? = null,

    @field:SerializedName("code")
    val code: String? = null,

    @field:SerializedName("message")
    val message: String? = null

) : Parcelable



