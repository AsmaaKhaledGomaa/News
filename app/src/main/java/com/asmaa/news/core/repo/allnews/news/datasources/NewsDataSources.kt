package com.asmaa.news.core.repo.allnews.news.datasources

import com.asmaa.news.core.models.ArticlesItem

interface NewsONDataSources{

    suspend fun getNewsDS(sourceId:String):List<ArticlesItem?>?


}

