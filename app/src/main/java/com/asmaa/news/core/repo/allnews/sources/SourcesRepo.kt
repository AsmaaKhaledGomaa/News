package com.asmaa.news.core.repo.allnews.sources

import com.asmaa.news.core.models.SourcesItem

interface SourcesRepo {

    suspend fun getSourcesR(category: String): List<SourcesItem?>?

}