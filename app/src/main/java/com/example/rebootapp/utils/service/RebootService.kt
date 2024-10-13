package com.example.rebootapp.utils.service

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.job.JobParameters
import android.app.job.JobService
import android.content.Context
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import com.example.rebootapp.domain.RebootRepository
import com.example.rebootapp.utils.isToday
import com.example.rebootapp.utils.localDateToString
import com.example.rebootapp.utils.receiver.JOB_ID
import java.time.LocalDate
import java.time.LocalDateTime
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.inject

class RebootService : JobService() {
    private val scope = CoroutineScope(Dispatchers.IO)
    private val rebootRepository: RebootRepository by inject(RebootRepository::class.java)

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onStartJob(params: JobParameters?): Boolean {
        scope.launch {
            val rebootInfo = try {
                rebootRepository.getRebootInfo().last { it.date.isToday() }
            } catch (ex: NoSuchElementException) {
                Log.d("reboot", "${ex.message}")
                null
            }
            sendNotification(
                context = applicationContext,
                currentDate = rebootInfo?.date ?: LocalDateTime.now().localDateToString(),
                rebootCount = rebootInfo?.count ?: 0
            )
        }
        return true
    }

    override fun onStopJob(params: JobParameters?): Boolean {
        return false
    }
}

private fun sendNotification(context: Context, rebootCount: Int, currentDate: String) {
    val notificationManager =
        context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    val channelId = "default_channel_id"

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val channel = NotificationChannel(
            channelId,
            "Job Service Channel",  // TODO Add this to constants
            NotificationManager.IMPORTANCE_DEFAULT
        )
        notificationManager.createNotificationChannel(channel)
    }

    val notification = NotificationCompat.Builder(context, channelId)
        .setContentTitle("Reboots Info")
        .setContentText(
            if (rebootCount == 0) {
                "No boots detected"
            } else {
                "The boot was detected $currentDate"
            }
        ) // TODO Add strings and add logic from point 3 (time between boots)
        .setSmallIcon(android.R.drawable.ic_dialog_info)
        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        .build()

    notificationManager.notify(JOB_ID, notification)
}