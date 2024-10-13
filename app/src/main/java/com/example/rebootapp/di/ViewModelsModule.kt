package com.example.rebootapp.di

import com.example.rebootapp.presentation.reboot.RebootViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel { RebootViewModel() }
}