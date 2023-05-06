package com.asmaa.news.repo.searchnews

import com.asmaa.news.api.WebServices
import com.asmaa.news.repo.searchnews.datasources.SearchNewsONDataSource
import com.asmaa.news.repo.searchnews.datasources.SearchNewsONDataSourcesIMP
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)

object SearchNewsModule {

    @Provides
    fun provideSearchNewsRepo( searchNewsONDataSource: SearchNewsONDataSource): SearchNewsRepo {
        return SearchNewsRepoIMP( searchNewsONDataSource )
    }

    @Provides
    fun provideSearchNewsOnlineDataSource(webServices: WebServices): SearchNewsONDataSource {
        return SearchNewsONDataSourcesIMP(webServices)
    }

}