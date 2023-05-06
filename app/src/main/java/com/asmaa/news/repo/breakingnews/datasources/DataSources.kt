package com.asmaa.news.repo.breakingnews.datasources

import com.asmaa.news.models.ArticlesItem



interface BreakingNewsONDataSource {

    suspend fun getTopNewsDS(country : String): List<ArticlesItem?>?

}
