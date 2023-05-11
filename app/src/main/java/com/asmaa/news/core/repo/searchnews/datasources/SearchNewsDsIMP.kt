package com.asmaa.news.core.repo.searchnews.datasources

import com.asmaa.news.core.di.constants.APIConstants
import com.asmaa.news.core.api.WebServices
import com.asmaa.news.core.models.ArticlesItem

class SearchNewsONDataSourcesIMP( val webServices: WebServices):SearchNewsONDataSource {

    override suspend fun searchNewsDS(search: String): List<ArticlesItem?>? {

        try {
            val result = webServices.searchNews(APIConstants.API_KEY, search)
            return result.articles!!

        } catch (ex: Exception) {
            throw ex
        }
    }
}
