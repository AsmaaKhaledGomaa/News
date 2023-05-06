package com.asmaa.news.repo.allnews.sources

import com.asmaa.news.models.SourcesItem

interface SourcesRepo {

    suspend fun getSourcesR(category: String): List<SourcesItem?>?

}