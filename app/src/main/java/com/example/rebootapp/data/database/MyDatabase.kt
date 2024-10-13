package com.example.rebootapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.rebootapp.data.model.RebootEntity

const val MY_DATA_BASE = "my-database"

@Database(entities = [RebootEntity::class], version = 2)
abstract class MyDatabase : RoomDatabase() {
    abstract fun getRebootDao(): RebootDao
}