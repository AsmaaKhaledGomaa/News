package com.asmaa.news.core.repo.home.breakingnews

import com.asmaa.news.core.models.ArticlesItem
import com.asmaa.news.core.repo.home.breakingnews.datasources.BreakingNewsONDataSource

class BreakingNewsRepoIMP(val breakingNewsONDataSource: BreakingNewsONDataSource):
    BreakingNewsRepo {

    override suspend fun getTopNewsR(country: String): List<ArticlesItem?>? {
        try {
            val result = breakingNewsONDataSource.getTopNewsDS(country)
            return result

        }catch (ex:Exception){
            throw ex
        }
    }
}