package com.uicheon.ytsocialapp.android

import android.app.Application
import com.uicheon.ytsocialapp.android.di.appModule
import com.uicheon.ytsocialapp.common.di.getSharedModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class SocialApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@SocialApplication)
            modules(appModule + getSharedModules())
        }
    }
}