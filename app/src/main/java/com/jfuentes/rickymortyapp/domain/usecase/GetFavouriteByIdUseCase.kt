package com.jfuentes.rickymortyapp.domain.usecase

import com.jfuentes.rickymortyapp.core.BaseUseCase
import com.jfuentes.rickymortyapp.domain.FavouritesRepo

/**
 * Created by Juan Fuentes on 01/07/2021.
 */
class GetFavouriteByIdUseCase(private val repo: FavouritesRepo) :
    BaseUseCase<GetFavouriteByIdUseCase.Params, GetFavouriteByIdUseCase.Result> {

    override suspend fun execute(params: Params): Result {
        return Result(repo.existFavourite(params.id))
    }

    data class Params(val id: Int)
    data class Result(val value: Boolean)
}



