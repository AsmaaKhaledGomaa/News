package com.asmaa.news.core.repo.allnews.news

import com.asmaa.news.core.api.WebServices
import com.asmaa.news.core.repo.allnews.news.datasources.NewsONDataSources
import com.asmaa.news.core.repo.allnews.news.datasources.NewsONDataSourcesIMP
import com.asmaa.news.core.repo.allnews.sources.datasources.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)

object NewsModule {

    @Provides
    fun provideNewsRepo(newsOnlineDataSource: NewsONDataSources): NewsRepo {
        return NewsRepoIMP(newsOnlineDataSource)
    }

    @Provides
    fun provideNewsOnlineDataSource(webServices: WebServices): NewsONDataSources {
        return NewsONDataSourcesIMP(webServices)
    }
}