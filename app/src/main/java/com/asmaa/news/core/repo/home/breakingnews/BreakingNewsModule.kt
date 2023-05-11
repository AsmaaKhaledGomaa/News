package com.asmaa.news.core.repo.home.breakingnews

import com.asmaa.news.core.api.WebServices
import com.asmaa.news.core.repo.home.breakingnews.datasources.BreakingNewsONDataSource
import com.asmaa.news.core.repo.home.breakingnews.datasources.BreakingNewsONDataSourceIMP
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)

object BreakingNewsModule {


    @Provides
    fun provideBreakingNewsRepo(breakingNewsONDataSource: BreakingNewsONDataSource): BreakingNewsRepo {
        return BreakingNewsRepoIMP(breakingNewsONDataSource)
    }

    @Provides
    fun provideBreakingNewsOnlineDataSource(webServices: WebServices): BreakingNewsONDataSource {
        return BreakingNewsONDataSourceIMP(webServices)
    }
}