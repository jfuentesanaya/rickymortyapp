package com.jfuentes.rickymortyapp.domain.usecase

import com.jfuentes.rickymortyapp.core.BaseUseCase
import com.jfuentes.rickymortyapp.domain.FavouritesRepo
import com.jfuentes.rickymortyapp.domain.model.FavouriteCharacter

/**
 * Created by Juan Fuentes on 01/07/2021.
 */
class AddCharacterToFavouriteUseCase (private val repo: FavouritesRepo) :
    BaseUseCase<AddCharacterToFavouriteUseCase.Params, BaseUseCase.NoResult> {

    override suspend fun execute(params: Params): BaseUseCase.NoResult {
        repo.insertFavourite(params.item)
        return BaseUseCase.NoResult
    }

    data class Params(val item: FavouriteCharacter)
}