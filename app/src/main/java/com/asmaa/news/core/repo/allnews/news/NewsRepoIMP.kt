package com.asmaa.news.core.repo.allnews.news

import com.asmaa.news.core.models.ArticlesItem
import com.asmaa.news.core.repo.allnews.news.datasources.NewsONDataSources

class NewsRepoIMP(val newsONDataSources: NewsONDataSources) : NewsRepo {

    override suspend fun getNewsR(sourceId: String): List<ArticlesItem?>? {
        try {
            val result = newsONDataSources.getNewsDS(sourceId)
            return result

        } catch (ex: Exception) {
            throw ex
        }
    }
}