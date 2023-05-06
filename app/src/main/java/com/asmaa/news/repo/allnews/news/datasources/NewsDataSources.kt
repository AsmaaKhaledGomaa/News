package com.asmaa.news.repo.allnews.datasources

import com.asmaa.news.models.ArticlesItem

interface NewsONDataSources{

    suspend fun getNewsDS(sourceId:String):List<ArticlesItem?>?


}

