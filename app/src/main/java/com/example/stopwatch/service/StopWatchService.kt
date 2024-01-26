package com.example.stopwatch.service

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import dagger.hilt.android.AndroidEntryPoint
import java.util.Random
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint
class StopWatchService: Service() {
    @Inject
    lateinit var notificationManager: NotificationManagerCompat

    @Inject
    lateinit var replyNotificationBuilder: NotificationCompat.Builder

    inner class LocalBinder : Binder() {
        // Return this instance of LocalService so clients can call public methods.
        fun getService(): StopWatchService = this@StopWatchService
    }

    private val binder = LocalBinder()

    var testingNum by mutableStateOf(0)
        private set

    var seconds by mutableStateOf(0)
        private set

    var minutes by mutableStateOf(0)
        private set

    var hours by mutableStateOf(0)
        private set

    var currentState by mutableStateOf(StopwatchState.Idle)
        private set

    fun makeRandomNum(): Int{
        testingNum = Random().nextInt(100)
        return testingNum
    }

    override fun onBind(intent: Intent?): IBinder? {
        return binder
    }

}

enum class StopwatchState {
    Idle,
    Started,
    Stopped,
    Canceled
}