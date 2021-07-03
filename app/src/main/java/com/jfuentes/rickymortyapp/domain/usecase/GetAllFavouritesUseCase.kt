package com.jfuentes.rickymortyapp.domain.usecase

import com.jfuentes.rickymortyapp.core.BaseUseCase
import com.jfuentes.rickymortyapp.domain.FavouritesRepo
import com.jfuentes.rickymortyapp.domain.model.FavouriteCharacter
import kotlinx.coroutines.flow.Flow

/**
 * Created by Juan Fuentes on 03/07/2021.
 */
class GetAllFavouritesUseCase(private val repo: FavouritesRepo) :
    BaseUseCase<BaseUseCase.NoParameter, Flow<List<FavouriteCharacter>>> {

    override suspend fun execute(params: BaseUseCase.NoParameter): Flow<List<FavouriteCharacter>> {
        return repo.getAll()
    }
}