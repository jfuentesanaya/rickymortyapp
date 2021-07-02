package com.jfuentes.rickymortyapp.domain.usecase

import com.jfuentes.rickymortyapp.core.BaseUseCase
import com.jfuentes.rickymortyapp.domain.FavouritesRepo
import com.jfuentes.rickymortyapp.domain.model.FavouriteCharacter

/**
 * Created by Juan Fuentes on 02/07/2021.
 */
class RemoveItemFromFavouriteUseCase (private val repo: FavouritesRepo) :
    BaseUseCase<RemoveItemFromFavouriteUseCase.Params, BaseUseCase.NoResult> {

    override suspend fun execute(params: Params): BaseUseCase.NoResult {
        repo.delete(params.item)
        return BaseUseCase.NoResult
    }

    data class Params(val item: FavouriteCharacter)
}