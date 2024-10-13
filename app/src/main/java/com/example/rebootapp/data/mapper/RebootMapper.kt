package com.example.rebootapp.data.mapper

import com.example.rebootapp.data.model.RebootEntity
import com.example.rebootapp.domain.model.RebootInfo


interface RebootMapper {
    fun mapRebootInfoToEntity(rebootInfo: RebootInfo): RebootEntity

    fun mapEntityToRebootInfo(rebootEntity: RebootEntity): RebootInfo
}