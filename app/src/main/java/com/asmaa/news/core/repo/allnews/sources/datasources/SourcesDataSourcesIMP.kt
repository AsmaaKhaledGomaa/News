package com.asmaa.news.core.repo.allnews.sources.datasources

import com.asmaa.news.core.di.constants.APIConstants
import com.asmaa.news.core.api.WebServices
import com.asmaa.news.core.dp.sources.SourcesDataBase
import com.asmaa.news.core.models.SourcesItem

class SourcesONDataSourcesIMP(val webServices: WebServices): SourcesONDataSources {

    override suspend fun getSourcesDS(category: String): List<SourcesItem?>? {
        try {
            val result = webServices.getSources(APIConstants.API_KEY, category, "en")
            return result.sources!!

        } catch (ex: Exception) {
            throw ex
        }
    }
}


class SourcesOFFDataSourcesIMP(val sourcesdataBase: SourcesDataBase): SourcesOFFDataSources {

    override suspend fun UpdataSourcesDS(sources: List<SourcesItem?>?) {
        sourcesdataBase.SourcesDao().upDateSources(sources)
    }

    override suspend fun getSourcesBYCategory(category: String): List<SourcesItem> {
        return sourcesdataBase.SourcesDao().getSourcesByCategory(category)
    }

}
