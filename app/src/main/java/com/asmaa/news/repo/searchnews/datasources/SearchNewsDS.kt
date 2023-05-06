package com.asmaa.news.repo.searchnews.datasources

import com.asmaa.news.models.ArticlesItem

interface SearchNewsONDataSource {

    suspend fun searchNewsDS( search: String): List<ArticlesItem?>?

}