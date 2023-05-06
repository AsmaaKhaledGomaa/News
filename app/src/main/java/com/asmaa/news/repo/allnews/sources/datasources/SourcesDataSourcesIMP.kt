package com.asmaa.news.repo.allnews.sources.datasources

import com.asmaa.news.Constans
import com.asmaa.news.api.WebServices
import com.asmaa.news.dp.sources.SourcesDataBase
import com.asmaa.news.models.SourcesItem

class SourcesONDataSourcesIMP(val webServices: WebServices): SourcesONDataSources {

    override suspend fun getSourcesDS(category: String): List<SourcesItem?>? {
        try {
            val result = webServices.getSources(Constans.API_KEY, category)
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
