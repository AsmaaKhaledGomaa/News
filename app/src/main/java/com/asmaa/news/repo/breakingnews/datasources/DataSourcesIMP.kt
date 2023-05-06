package com.asmaa.news.repo.breakingnews.datasources

import com.asmaa.news.Constans
import com.asmaa.news.api.WebServices
import com.asmaa.news.models.ArticlesItem

class BreakingNewsONDataSourceIMP(val webServices: WebServices): BreakingNewsONDataSource {


    override suspend fun getTopNewsDS(country: String): List<ArticlesItem?>? {
        try {
            val tobNews = webServices.getTopNews(Constans.API_KEY,"us")
            return tobNews.articles!!

        }catch (ex:Exception){
            throw ex
        }
    }
}
