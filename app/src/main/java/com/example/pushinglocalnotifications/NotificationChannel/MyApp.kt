package com.example.pushinglocalnotifications.NotificationChannel

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        creatNotificationChannel()
    }

    private fun creatNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CounterNotificationService.Counter_Channel_id,
                "counter",
                NotificationManager.IMPORTANCE_DEFAULT
            )

        }
    }
}