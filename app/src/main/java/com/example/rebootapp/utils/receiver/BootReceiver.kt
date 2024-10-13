package com.example.rebootapp.utils.receiver

import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.BroadcastReceiver
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.rebootapp.domain.RebootRepository
import com.example.rebootapp.domain.model.RebootInfo
import com.example.rebootapp.utils.localDateToString
import com.example.rebootapp.utils.service.RebootService
import java.time.LocalDate
import java.time.LocalDateTime
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.inject

const val JOB_ID = 111

class BootReceiver : BroadcastReceiver() {
    private val scope = CoroutineScope(Dispatchers.IO)
    private val rebootRepository: RebootRepository by inject(RebootRepository::class.java)

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == Intent.ACTION_BOOT_COMPLETED) {
            scope.launch {
                rebootRepository.saveRebootInfo(
                    rebootInfo = RebootInfo(
                        count = 1,
                        date = LocalDateTime.now().localDateToString()
                    )
                )
            }
        }
    }
}

fun scheduleJob(context: Context) {
    val componentName = ComponentName(context, RebootService::class.java)
    val jobInfo = JobInfo.Builder(JOB_ID, componentName)
        .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
        .setPersisted(true)
        .setPeriodic(15 * 60 * 1000)
        .build()

    val jobScheduler = context.getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler
    jobScheduler.schedule(jobInfo)
}