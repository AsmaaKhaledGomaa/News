package com.asmaa.news.core.repo.searchnews.datasources

import com.asmaa.news.core.models.ArticlesItem

interface SearchNewsONDataSource {

    suspend fun searchNewsDS( search: String): List<ArticlesItem?>?

}