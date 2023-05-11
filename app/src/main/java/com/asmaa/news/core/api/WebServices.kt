package com.asmaa.news.core.api

import com.asmaa.news.core.payloads.NewsResponse
import com.asmaa.news.core.payloads.SourcesResponse
import retrofit2.http.GET
import retrofit2.http.Query


interface WebServices {

    @GET("v2/top-headlines/sources")
    suspend fun getSources(
        @Query("apiKey") apiKey: String,
        @Query("category") category: String
    ): SourcesResponse

    @GET ("v2/everything")
    suspend fun getNews(
        @Query("apiKey") apiKey: String,
        @Query("sources") sources: String
    ): NewsResponse


    @GET("v2/top-headlines")
    suspend fun getTopNews(
        @Query("apiKey") apiKey: String,
        @Query("country") country: String
    ): NewsResponse

    @GET ("v2/everything")
    suspend fun searchNews(
        @Query("apiKey") apiKey: String,
        @Query("q") q: String
    ): NewsResponse


}