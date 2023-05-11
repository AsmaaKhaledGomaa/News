package com.asmaa.news.core.repo.home.discovernews

import com.asmaa.news.core.models.ArticlesItem
import com.asmaa.news.core.repo.home.discovernews.datasource.DiscoverNewsONDataSource

class DiscoverNewsRepoIMP(val discoverNewsONDataSource: DiscoverNewsONDataSource):DiscoverNewsRepo {

    override suspend fun getDiscoverNews(): List<ArticlesItem?>? {

        try {
            val result= discoverNewsONDataSource.getDiscoverNewsDS()
            return result
        }catch (ex:Exception){
            throw ex
        }

    }


}