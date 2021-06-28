package com.jfuentes.rickymortyapp

import android.app.Application
import com.jfuentes.rickymortyapp.data.remote.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Created by Juan Fuentes on 25/06/2021.
 */
class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BaseApplication)
            modules(networkModule)
        }
    }
}