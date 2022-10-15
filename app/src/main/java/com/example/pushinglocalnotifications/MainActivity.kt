package com.example.pushinglocalnotifications

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pushinglocalnotifications.NotificationChannel.CounterNotificationService
import com.example.pushinglocalnotifications.NotificationChannel.counter
import com.example.pushinglocalnotifications.NotificationChannel.counternotificationreciver
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val serice = CounterNotificationService(applicationContext)
        setContentView(R.layout.activity_main)
        shownotifaication.setOnClickListener {
            serice.shownotification(counter.value)
        }
    }
}