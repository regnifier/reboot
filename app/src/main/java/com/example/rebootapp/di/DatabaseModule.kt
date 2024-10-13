package com.example.rebootapp.di

import androidx.room.Room
import com.example.rebootapp.data.database.MY_DATA_BASE
import com.example.rebootapp.data.database.MyDatabase
import org.koin.dsl.module

val databaseModule = module {
    single { Room.databaseBuilder(get(), MyDatabase::class.java, MY_DATA_BASE).build() }
    single { get<MyDatabase>().getRebootDao() }
}