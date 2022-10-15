package com.example.pushinglocalnotifications.NotificationChannel

import android.app.Application
import android.os.Build

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        creatNotificationChannel()
    }

    private fun creatNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

        }
    }
}