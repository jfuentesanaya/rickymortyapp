package com.jfuentes.rickymortyapp.data.local.di

import android.app.Application
import androidx.room.Room
import com.jfuentes.rickymortyapp.data.FavouritesRepoImpl
import com.jfuentes.rickymortyapp.data.local.AppDataBase
import com.jfuentes.rickymortyapp.data.local.FavouriteDAO
import com.jfuentes.rickymortyapp.domain.FavouritesRepo
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module


/**
 * Created by Juan Fuentes on 01/07/2021.
 */
val databaseModule = module {

    single { provideDataBase(androidApplication()) }
    single { provideFavouriteDao(get()) }
    single { provideRepo(get()) }
}

private fun provideDataBase(application: Application) =
    Room.databaseBuilder(application, AppDataBase::class.java, "favourites_database").build()

private fun provideFavouriteDao(database: AppDataBase): FavouriteDAO {
    return database.favouriteDAO()
}

private fun provideRepo(dao: FavouriteDAO) : FavouritesRepo {
    return FavouritesRepoImpl(dao)
}