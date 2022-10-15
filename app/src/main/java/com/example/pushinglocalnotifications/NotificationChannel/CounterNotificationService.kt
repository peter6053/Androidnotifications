package com.example.pushinglocalnotifications.NotificationChannel

import android.content.Context
import androidx.core.app.NotificationCompat
import com.example.pushinglocalnotifications.R

class CounterNotificationService(private val context: Context) {

    fun shownotification(Counter: Int) {

        val notification = NotificationCompat.Builder(context, Counter_Channel_id)
            .setSmallIcon(R.drawable.ic_baseline_baby_changing_station_24)


    }

    companion object {
        const val Counter_Channel_id = "counterchannel"
    }
}