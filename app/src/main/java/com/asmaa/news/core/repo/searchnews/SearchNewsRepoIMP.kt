package com.asmaa.news.core.repo.searchnews

import com.asmaa.news.core.models.ArticlesItem
import com.asmaa.news.core.repo.searchnews.datasources.SearchNewsONDataSource

class SearchNewsRepoIMP(val searchNewsONDataSource: SearchNewsONDataSource) :SearchNewsRepo {

    override suspend fun searchNews(search: String): List<ArticlesItem?>? {

        try {
            val result = searchNewsONDataSource.searchNewsDS(search)
            return result

        } catch (ex: Exception) {
            throw ex
        }
    }
}