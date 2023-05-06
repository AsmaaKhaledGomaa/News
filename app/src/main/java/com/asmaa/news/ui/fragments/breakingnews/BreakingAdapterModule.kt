package com.asmaa.news.ui.fragments.breakingnews

import com.asmaa.news.adapters.ViewPaggerAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
object BreakingNewsAdapterModule {

    @Provides
    fun provideBreakingNewsAdapter(): ViewPaggerAdapter{
        return ViewPaggerAdapter()
    }
}