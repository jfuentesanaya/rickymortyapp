package com.jfuentes.rickymortyapp.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.jfuentes.rickymortyapp.data.local.model.FavouriteEntity

/**
 * Created by Juan Fuentes on 01/07/2021.
 */
@Dao
interface FavouriteDAO {

    @Query("SELECT * FROM favouriteEntity")
    suspend fun getAll(): List<FavouriteEntity>

    @Query("SELECT * FROM favouriteEntity WHERE id LIKE :characterId")
    suspend fun findById(characterId: Int): FavouriteEntity

    @Delete
    suspend fun delete(user: FavouriteEntity)

    @Query("SELECT EXISTS (SELECT * FROM favouriteEntity WHERE id = :id)")
    suspend fun exists(id: Int): Boolean

    @Insert
    suspend fun insert(user: FavouriteEntity)

}