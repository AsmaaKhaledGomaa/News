package com.asmaa.news.core.repo.allnews.news.datasources

import com.asmaa.news.core.constants.APIConstants
import com.asmaa.news.core.api.WebServices
import com.asmaa.news.core.models.ArticlesItem

class NewsONDataSourcesIMP(val webServices: WebServices): NewsONDataSources {

    override suspend fun getNewsDS(sourceId: String): List<ArticlesItem?>? {

        try {
            val result = webServices.getNews(APIConstants.API_KEY, sourceId)
            return result.articles!!

        } catch (ex: Exception) {
            throw ex
        }
    }


}