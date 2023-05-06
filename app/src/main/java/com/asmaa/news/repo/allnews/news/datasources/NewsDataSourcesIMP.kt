package com.asmaa.news.repo.allnews.datasources

import com.asmaa.news.Constans
import com.asmaa.news.api.WebServices
import com.asmaa.news.models.ArticlesItem

class NewsONDataSourcesIMP(val webServices: WebServices):NewsONDataSources {

    override suspend fun getNewsDS(sourceId: String): List<ArticlesItem?>? {

        try {
            val result = webServices.getNews(Constans.API_KEY, sourceId)
            return result.articles!!

        } catch (ex: Exception) {
            throw ex
        }
    }


}