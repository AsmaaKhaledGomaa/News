package com.asmaa.news.core.repo.allnews.news

import com.asmaa.news.core.models.ArticlesItem


interface NewsRepo {

    suspend fun getNewsR(sourceId:String) :List<ArticlesItem?>?
}