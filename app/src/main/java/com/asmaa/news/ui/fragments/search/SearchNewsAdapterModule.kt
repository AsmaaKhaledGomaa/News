package com.asmaa.news.ui.fragments.search

import com.asmaa.news.adapters.SearchAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent


@Module
@InstallIn(FragmentComponent::class)
object SearchNewsAdapterModule {

    @Provides
    fun provideSearchNewsAdapter(): SearchAdapter{
        return SearchAdapter()
    }


}