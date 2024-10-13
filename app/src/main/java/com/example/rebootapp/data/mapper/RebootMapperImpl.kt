package com.example.rebootapp.data.mapper

import com.example.rebootapp.data.model.RebootEntity
import com.example.rebootapp.domain.model.RebootInfo


class RebootMapperImpl : RebootMapper {
    override fun mapRebootInfoToEntity(rebootInfo: RebootInfo): RebootEntity = with(rebootInfo) {
        RebootEntity(
            date = date,
            count = count
        )
    }

    override fun mapEntityToRebootInfo(rebootEntity: RebootEntity): RebootInfo =
        with(rebootEntity) {
            RebootInfo(
                date = date,
                count = count
            )
        }
}