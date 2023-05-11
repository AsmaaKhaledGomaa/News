package com.asmaa.news

import android.app.Application
import com.asmaa.news.core.dp.sources.SourcesDataBase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class Application : Application() {

    // Methods:
    override fun onCreate() {
        // Super:
        super.onCreate()
        // Initializations:
        SourcesDataBase.init(this)
    }
}