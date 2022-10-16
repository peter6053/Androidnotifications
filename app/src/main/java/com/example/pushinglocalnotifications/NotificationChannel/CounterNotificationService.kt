package com.example.pushinglocalnotifications.NotificationChannel

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import com.example.pushinglocalnotifications.MainActivity
import com.example.pushinglocalnotifications.R

class CounterNotificationService(private val context: Context) {
    private val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    fun shownotification(Counter: Int) {
        val activityintent = Intent(context, MainActivity::class.java)
        val activitypendingintent = PendingIntent.getActivities(
            context,
            1,
            arrayOf(activityintent),
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) PendingIntent.FLAG_IMMUTABLE else 0
        )
        val inncreementintent = PendingIntent.getBroadcast(
            context,
            2,
            Intent(
                context, counternotificationreciver::class.java
            ),
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) PendingIntent.FLAG_IMMUTABLE else 0
        )

        val notification = NotificationCompat.Builder(context, Counter_Channel_id)
            .setSmallIcon(R.drawable.ic_baseline_baby_changing_station_24)
            .setContentTitle("Increementcounter")
            .setContentText("the count is $Counter")
            .setContentIntent(activitypendingintent)
            .addAction(
                R.drawable.ic_baseline_baby_changing_station_24,
                "increeement",
                inncreementintent
            )
            .build()
        notificationManager.notify(1, notification)
    }

    companion object {
        const val Counter_Channel_id = "counterchannel"
    }
}