package com.jfuentes.rickymortyapp.presentation.di

import com.jfuentes.rickymortyapp.presentation.viewmodel.ListVM
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Juan Fuentes on 29/06/2021.
 */
val viewModelModule = module {
    viewModel { ListVM(get()) }
}