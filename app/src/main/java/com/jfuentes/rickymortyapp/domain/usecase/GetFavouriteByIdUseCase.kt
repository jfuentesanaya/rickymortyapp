package com.jfuentes.rickymortyapp.domain.usecase

import com.jfuentes.rickymortyapp.core.BaseUseCase
import com.jfuentes.rickymortyapp.domain.FavouritesRepo
import kotlinx.coroutines.flow.Flow

/**
 * Created by Juan Fuentes on 01/07/2021.
 */
class GetFavouriteByIdUseCase(private val repo: FavouritesRepo) :
    BaseUseCase<GetFavouriteByIdUseCase.Params, Flow<Boolean>> {

    override suspend fun execute(params: Params): Flow<Boolean> {
        return repo.existFavourite(params.id)
    }

    data class Params(val id: Int)
}



