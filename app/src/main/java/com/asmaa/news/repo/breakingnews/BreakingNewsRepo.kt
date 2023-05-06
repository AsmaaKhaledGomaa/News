package com.asmaa.news.repo.breakingnews

import com.asmaa.news.models.ArticlesItem


interface BreakingNewsRepo {

    suspend fun getTopNewsR(country : String): List<ArticlesItem?>?

}



