package com.asmaa.news.core.repo.home.discovernews.datasource

import com.asmaa.news.core.models.ArticlesItem



interface DiscoverNewsONDataSource{

    suspend fun getDiscoverNewsDS(): List<ArticlesItem?>?
}