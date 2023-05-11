package com.asmaa.news.core.repo.home.discovernews

import com.asmaa.news.core.api.WebServices
import com.asmaa.news.core.repo.home.discovernews.datasource.DiscoverNewsONDataSource
import com.asmaa.news.core.repo.home.discovernews.datasource.DiscoverNewsONDataSourcesIMP
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)

object DiscoverNewsModule {

    @Provides
    fun provideDiscoverNewsRepo(discoverNewsRepoONDataSource: DiscoverNewsONDataSource):DiscoverNewsRepo{
        return DiscoverNewsRepoIMP(discoverNewsRepoONDataSource)
    }

    @Provides
    fun provideDiscoverNewsONDataSource(webServices: WebServices):DiscoverNewsONDataSource{
        return DiscoverNewsONDataSourcesIMP(webServices)

    }

}