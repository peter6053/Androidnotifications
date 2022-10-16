package com.example.pushinglocalnotifications

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.widget.RemoteViews
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import com.example.pushinglocalnotifications.NotificationChannel.MainActivitytwo
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

const val channel_id = "notificationchallel"
const val channelname = " com.example.pushinglocalnotifications"

class MyFirebaseInstanceIDService : FirebaseMessagingService() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
      if (remoteMessage.getNotification() != null){
          generatenotifiaction(remoteMessage.notification!!.title!!,remoteMessage.notification!!.body!!)
      }
    }

    //generate the notifiacation
    //attach notifiaction
    private fun getremoteview(title: String, message: String): RemoteViews {

        val remoteview = RemoteViews("com.example.pushinglocalnotifications", R.layout.notification)
        remoteview.setTextViewText(R.id.title, title)
        remoteview.setTextViewText(R.id.message, message)
        remoteview.setImageViewResource(
            R.id.app_logo,
            R.drawable.ic_baseline_notification_important_24
        )

        return remoteview
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun generatenotifiaction(title: String, message: String) {
        val intent = Intent(this, MainActivitytwo::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        val pendingintent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT)
        //channel id
        //channel name
        var builder: NotificationCompat.Builder = NotificationCompat.Builder(
            applicationContext,
            channel_id,
        )
            .setSmallIcon(R.drawable.ic_baseline_notification_important_24)
            .setAutoCancel(true)
            .setVibrate(longArrayOf(1000, 1000, 1000, 1000))
            .setOnlyAlertOnce(true)
            .setContentIntent(pendingintent)
        builder = builder.setContent(getremoteview(title, message))
        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val notifiacationnchannel = NotificationChannel(
                channel_id, channelname, NotificationManager.IMPORTANCE_HIGH
            )
            notificationManager.createNotificationChannel(notifiacationnchannel)
        }
        notificationManager.notify(0, builder.build())

    }


}