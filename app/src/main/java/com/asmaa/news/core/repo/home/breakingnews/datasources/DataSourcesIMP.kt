package com.asmaa.news.core.repo.home.breakingnews.datasources

import com.asmaa.news.core.di.constants.APIConstants
import com.asmaa.news.core.api.WebServices
import com.asmaa.news.core.models.ArticlesItem

class BreakingNewsONDataSourceIMP(val webServices: WebServices): BreakingNewsONDataSource {


    override suspend fun getTopNewsDS(country: String): List<ArticlesItem?>? {
        try {
            val tobNews = webServices.getTopNews(APIConstants.API_KEY,"us", "en")
            return tobNews.articles!!

        }catch (ex:Exception){
            throw ex
        }
    }
}
