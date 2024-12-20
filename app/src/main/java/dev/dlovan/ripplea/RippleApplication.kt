package dev.dlovan.ripplea

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class RippleApplication: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}
