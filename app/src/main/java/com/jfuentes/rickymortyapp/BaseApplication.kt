package com.jfuentes.rickymortyapp

import android.app.Application
import com.jfuentes.rickymortyapp.data.remote.di.networkModule
import com.jfuentes.rickymortyapp.domain.di.useCaseModule
import com.jfuentes.rickymortyapp.presentation.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

/**
 * Created by Juan Fuentes on 25/06/2021.
 */
class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@BaseApplication)
            modules(listOf(networkModule, useCaseModule, viewModelModule))
        }
    }
}