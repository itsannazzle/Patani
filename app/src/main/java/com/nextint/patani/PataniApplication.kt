package com.nextint.patani

import android.app.Application
import timber.log.Timber

class PataniApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}