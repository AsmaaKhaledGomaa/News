package com.asmaa.news.repo.allnews.sources

import com.asmaa.news.network.NetworkHandler
import com.asmaa.news.api.WebServices
import com.asmaa.news.dp.sources.SourcesDataBase
import com.asmaa.news.repo.allnews.datasources.*
import com.asmaa.news.repo.allnews.sources.datasources.SourcesOFFDataSources
import com.asmaa.news.repo.allnews.sources.datasources.SourcesOFFDataSourcesIMP
import com.asmaa.news.repo.allnews.sources.datasources.SourcesONDataSources
import com.asmaa.news.repo.allnews.sources.datasources.SourcesONDataSourcesIMP
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

object SourcesModule {

    @Provides
    fun provideONDataSource(webServices: WebServices): SourcesONDataSources {
        return SourcesONDataSourcesIMP(webServices)
    }

    @Provides
    fun provideOFFDataSource(sourcesDataBase: SourcesDataBase): SourcesOFFDataSources {
        return SourcesOFFDataSourcesIMP(sourcesDataBase)
    }

    @Singleton
    @Provides
    fun provideDataBase():SourcesDataBase{
        return SourcesDataBase.getInstance()
    }


    @Provides
    fun sourcesRepo(sourcesONDataSource: SourcesONDataSources,
                    sourcesOFFDataSources: SourcesOFFDataSources,
                    networkHandler: NetworkHandler
    ): SourcesRepo {

        return SourcesRepoIMP(sourcesONDataSource,sourcesOFFDataSources,networkHandler)
    }
}