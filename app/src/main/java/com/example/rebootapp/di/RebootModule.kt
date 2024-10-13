package com.example.rebootapp.di

import com.example.rebootapp.data.mapper.RebootMapper
import com.example.rebootapp.data.mapper.RebootMapperImpl
import com.example.rebootapp.data.repository.RebootRepositoryImpl
import com.example.rebootapp.domain.RebootRepository
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val rebootModule = module {
    single<RebootRepository> {
        RebootRepositoryImpl(
            ioDispatcher = Dispatchers.IO,
            rebootDao = get(),
            mapper = get()
        )
    }

    factory<RebootMapper> { RebootMapperImpl() }
}