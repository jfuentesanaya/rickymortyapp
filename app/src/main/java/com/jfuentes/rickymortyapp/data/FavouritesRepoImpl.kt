package com.jfuentes.rickymortyapp.data

import com.jfuentes.rickymortyapp.data.local.FavouriteDAO
import com.jfuentes.rickymortyapp.data.local.model.FavouriteEntity
import com.jfuentes.rickymortyapp.domain.FavouritesRepo
import com.jfuentes.rickymortyapp.domain.model.FavouriteCharacter
import kotlinx.coroutines.flow.Flow


/**
 * Created by Juan Fuentes on 02/07/2021.
 */
class FavouritesRepoImpl (private val dao: FavouriteDAO): FavouritesRepo {

    override suspend fun getAll(): List<FavouriteCharacter> {
        return dao.getAll().map { it.toFavouriteCharacter() }
    }

    override suspend fun findById(characterId: Int): FavouriteCharacter {
        return dao.findById(characterId).toFavouriteCharacter()
    }

    override suspend fun delete(item: FavouriteCharacter) {
        dao.delete(item.toFavoriteEntity())
    }

    override suspend fun insertFavourite(item: FavouriteCharacter) {
        dao.insert(item.toFavoriteEntity())
    }

    override fun existFavourite(id: Int): Flow<Boolean> {
        return dao.exists(id)
    }
}

fun FavouriteCharacter.toFavoriteEntity() = FavouriteEntity(id, name, image)
fun FavouriteEntity.toFavouriteCharacter() = FavouriteCharacter(id, name, image)