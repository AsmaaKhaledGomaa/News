package com.asmaa.news

import android.app.Application
import com.asmaa.news.dp.sources.SourcesDataBase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication:Application() {

    override fun onCreate() {
        super.onCreate()
        SourcesDataBase.init(this)
    }
}