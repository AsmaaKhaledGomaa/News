package com.asmaa.news.repo.searchnews.datasources

import com.asmaa.news.Constans
import com.asmaa.news.api.WebServices
import com.asmaa.news.models.ArticlesItem

class SearchNewsONDataSourcesIMP( val webServices: WebServices):SearchNewsONDataSource {

    override suspend fun searchNewsDS(search: String): List<ArticlesItem?>? {

        try {
            val result = webServices.searchNews(Constans.API_KEY, search)
            return result.articles!!

        } catch (ex: Exception) {
            throw ex
        }
    }
}
