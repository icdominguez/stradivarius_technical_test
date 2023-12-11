package com.icdominguez.stradivariustechnicaltest

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class StradivariusApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}
