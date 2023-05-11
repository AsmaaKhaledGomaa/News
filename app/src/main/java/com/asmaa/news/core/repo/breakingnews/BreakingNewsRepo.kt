package com.asmaa.news.core.repo.breakingnews

import com.asmaa.news.core.models.ArticlesItem


interface BreakingNewsRepo {

    suspend fun getTopNewsR(country : String): List<ArticlesItem?>?

}



