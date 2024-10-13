package com.example.rebootapp.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.rebootapp.data.model.RebootEntity

@Dao
interface RebootDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRebootInfo(rebootEntity: RebootEntity)

    @Query("SELECT * FROM rebootentity")
    fun getRebootInfo(): List<RebootEntity>
}