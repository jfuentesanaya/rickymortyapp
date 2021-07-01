package com.jfuentes.rickymortyapp.data.local.di

import android.app.Application
import androidx.room.Room
import com.jfuentes.rickymortyapp.data.local.AppDataBase
import com.jfuentes.rickymortyapp.data.local.FavouriteDAO
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module


/**
 * Created by Juan Fuentes on 01/07/2021.
 */
val databaseModule = module {

    single { provideDataBase(androidApplication()) }
    single { provideFavouriteDao(get()) }
}

private fun provideDataBase(application: Application) =
    Room.databaseBuilder(application, AppDataBase::class.java, "favourites_database").build()

private fun provideFavouriteDao(database: AppDataBase): FavouriteDAO {
    return database.favouriteDAO()
}