package com.asmaa.news.repo.allnews.sources

import com.asmaa.news.network.NetworkHandler
import com.asmaa.news.models.SourcesItem
import com.asmaa.news.repo.allnews.sources.datasources.SourcesOFFDataSources
import com.asmaa.news.repo.allnews.sources.datasources.SourcesONDataSources

class SourcesRepoIMP(val sourcesONDataSources : SourcesONDataSources,
                     val sourcesOFFDataSources: SourcesOFFDataSources,
                     val networkHandler : NetworkHandler
): SourcesRepo {

    override suspend fun getSourcesR(category: String): List<SourcesItem?>? {

        try {
            if (networkHandler.isOnline())
            {
                val result = sourcesONDataSources.getSourcesDS(category)
                sourcesOFFDataSources.UpdataSourcesDS(result)
                return result
            }
            return sourcesOFFDataSources.getSourcesBYCategory(category)

        } catch (ex:Exception){
            throw ex
            return sourcesOFFDataSources.getSourcesBYCategory(category)
        }
    }
}
