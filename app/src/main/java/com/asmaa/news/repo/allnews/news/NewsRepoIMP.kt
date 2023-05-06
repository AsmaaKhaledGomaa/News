package com.asmaa.news.repo.allnews.news

import com.asmaa.news.models.ArticlesItem
import com.asmaa.news.repo.allnews.datasources.NewsONDataSources

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