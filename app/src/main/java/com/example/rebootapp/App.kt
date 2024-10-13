package com.example.rebootapp

import android.app.Application
import com.example.rebootapp.di.databaseModule
import com.example.rebootapp.di.rebootModule
import com.example.rebootapp.di.viewModelsModule
import com.example.rebootapp.utils.receiver.scheduleJob
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@App)
            modules(
                databaseModule,
                rebootModule,
                viewModelsModule
            )
        }
        scheduleJob(applicationContext)
    }
}