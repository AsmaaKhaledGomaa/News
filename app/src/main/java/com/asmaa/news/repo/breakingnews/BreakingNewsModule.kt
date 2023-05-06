package com.asmaa.news.repo.breakingnews

import com.asmaa.news.api.WebServices
import com.asmaa.news.repo.breakingnews.datasources.BreakingNewsONDataSource
import com.asmaa.news.repo.breakingnews.datasources.BreakingNewsONDataSourceIMP
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