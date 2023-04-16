package com.asmaa.news.api

import com.asmaa.news.models.NewsResponse
import com.asmaa.news.models.SourcesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WebServices {

    @GET("v2/top-headlines/sources")
    fun getSources(
        @Query("apiKey") apiKey: String
    ): Call<SourcesResponse>

    @GET ("v2/everything")
    fun getNews(
        @Query("apiKey") apiKey: String,
        @Query("sources") sources: String
    ): Call<NewsResponse>

}