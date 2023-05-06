package com.asmaa.news.repo.breakingnews

import com.asmaa.news.models.ArticlesItem
import com.asmaa.news.repo.breakingnews.datasources.BreakingNewsONDataSource

class BreakingNewsRepoIMP(val breakingNewsONDataSource: BreakingNewsONDataSource): BreakingNewsRepo {

    override suspend fun getTopNewsR(country: String): List<ArticlesItem?>? {
        try {
            val result = breakingNewsONDataSource.getTopNewsDS(country)
            return result

        }catch (ex:Exception){
            throw ex
        }
    }
}