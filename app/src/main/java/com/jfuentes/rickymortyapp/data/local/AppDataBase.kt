package com.jfuentes.rickymortyapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jfuentes.rickymortyapp.data.local.model.FavouriteEntity

/**
 * Created by Juan Fuentes on 01/07/2021.
 */
@Database(entities = [FavouriteEntity::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun favouriteDAO(): FavouriteDAO

}