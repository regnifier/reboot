package com.example.rebootapp.domain

import com.example.rebootapp.domain.model.RebootInfo

interface RebootRepository {
    suspend fun saveRebootInfo(rebootInfo: RebootInfo)

    suspend fun getRebootInfo(): List<RebootInfo>
}