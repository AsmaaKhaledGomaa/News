package com.asmaa.news.ui.fragments.allnews

import com.asmaa.news.core.adapters.NewsAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
object AdaptersModule {

    @Provides
    fun provideSourcesAdapter(): NewsAdapter {
        return NewsAdapter()
    }
}