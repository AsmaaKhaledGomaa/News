package com.asmaa.news.core.repo.home.discovernews

import com.asmaa.news.core.models.ArticlesItem

interface DiscoverNewsRepo {

    suspend fun getDiscoverNews(): List<ArticlesItem?>?
}