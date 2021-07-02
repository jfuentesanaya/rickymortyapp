package com.jfuentes.rickymortyapp.domain

import com.jfuentes.rickymortyapp.domain.model.FavouriteCharacter

/**
 * Created by Juan Fuentes on 02/07/2021.
 */
interface FavouritesRepo {

    suspend fun getAll(): List<FavouriteCharacter>

    suspend fun findById(characterId: Int): FavouriteCharacter

    suspend fun delete(item: FavouriteCharacter)

    suspend fun insertFavourite(item: FavouriteCharacter)

    suspend fun existFavourite(id: Int): Boolean
}