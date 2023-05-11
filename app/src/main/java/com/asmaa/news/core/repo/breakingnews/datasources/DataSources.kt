package com.asmaa.news.core.repo.breakingnews.datasources

import com.asmaa.news.core.models.ArticlesItem



interface BreakingNewsONDataSource {

    suspend fun getTopNewsDS(country : String): List<ArticlesItem?>?

}
