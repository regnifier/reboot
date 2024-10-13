package com.example.rebootapp.data.repository

import com.example.rebootapp.data.database.RebootDao
import com.example.rebootapp.data.mapper.RebootMapper
import com.example.rebootapp.domain.RebootRepository
import com.example.rebootapp.domain.model.RebootInfo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class RebootRepositoryImpl(
    private val ioDispatcher: CoroutineDispatcher,
    private val rebootDao: RebootDao,
    private val mapper: RebootMapper
) : RebootRepository {
    override suspend fun saveRebootInfo(rebootInfo: RebootInfo) = withContext(ioDispatcher) {
        rebootDao.insertRebootInfo(mapper.mapRebootInfoToEntity(rebootInfo))
    }

    override suspend fun getRebootInfo(): List<RebootInfo> = withContext(ioDispatcher) {
        rebootDao.getRebootInfo().map { mapper.mapEntityToRebootInfo(it) }
    }
}