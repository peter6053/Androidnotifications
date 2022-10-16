package com.example.pushinglocalnotifications.NotificationChannel

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class counternotificationreciver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent?) {
        val service = CounterNotificationService(context)
        service.shownotification(++counter.value)
    }
}