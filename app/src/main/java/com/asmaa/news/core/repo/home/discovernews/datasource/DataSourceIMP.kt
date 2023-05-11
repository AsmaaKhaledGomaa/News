package com.asmaa.news.core.repo.home.discovernews.datasource

import com.asmaa.news.core.api.WebServices
import com.asmaa.news.core.di.constants.APIConstants
import com.asmaa.news.core.models.ArticlesItem

class DiscoverNewsONDataSourcesIMP(val webServices: WebServices): DiscoverNewsONDataSource {

    override suspend fun getDiscoverNewsDS(): List<ArticlesItem?>? {

        try {
            val result = webServices.getDiscoverNews(APIConstants.API_KEY,"en")
            return result.articles!!

        }catch (ex:Exception){
            throw ex
        }
    }

}