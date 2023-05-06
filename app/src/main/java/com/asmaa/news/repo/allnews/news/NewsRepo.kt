package com.asmaa.news.repo.allnews.news

import com.asmaa.news.models.ArticlesItem


interface NewsRepo {

    suspend fun getNewsR(sourceId:String) :List<ArticlesItem?>?
}