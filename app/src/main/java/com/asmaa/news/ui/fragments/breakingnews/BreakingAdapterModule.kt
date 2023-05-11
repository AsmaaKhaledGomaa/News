package com.asmaa.news.ui.fragments.breakingnews

import com.asmaa.news.core.adapters.DiscoverAdapter
import com.asmaa.news.core.adapters.ViewPaggerAdapter
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


@Module
@InstallIn(FragmentComponent::class)
object DiscoverNewsAdapterModule{

    @Provides
    fun provideDiscoverNewsAdapter(): DiscoverAdapter{
        return DiscoverAdapter()
    }

}