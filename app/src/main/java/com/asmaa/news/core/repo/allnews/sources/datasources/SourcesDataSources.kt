package com.asmaa.news.core.repo.allnews.sources.datasources

import com.asmaa.news.core.models.SourcesItem

interface SourcesONDataSources{

    suspend fun getSourcesDS(category: String):List<SourcesItem?>?



}


interface SourcesOFFDataSources{

    suspend fun UpdataSourcesDS(sources :List<SourcesItem?>?)

    suspend fun getSourcesBYCategory(category: String):List<SourcesItem>

}