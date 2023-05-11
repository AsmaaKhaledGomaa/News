package com.asmaa.news.core.di

import android.content.Context
import com.asmaa.news.core.network.NetworkHandler
import com.asmaa.news.NetworkHandlerImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)

class UtilsModule {
    @Provides
    fun provideNetworkHandler(@ApplicationContext context: Context): NetworkHandler {
        return NetworkHandlerImpl(context)
    }
}