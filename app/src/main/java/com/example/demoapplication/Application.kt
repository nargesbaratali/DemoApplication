package com.example.demoapplication

import android.content.res.Configuration
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject
import android.app.Application


@HiltAndroidApp
 class Application: Application() {

    override fun onCreate() {
        super.onCreate()
       // Fresco.initialize(this)
    }



}