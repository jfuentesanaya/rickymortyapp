package com.jfuentes.rickymortyapp.domain.usecase

import com.jfuentes.rickymortyapp.core.BaseUseCase
import com.jfuentes.rickymortyapp.domain.RickyMortyService
import com.jfuentes.rickymortyapp.domain.model.Character

/**
 * Created by Juan Fuentes on 28/06/2021.
 */
class GetDetailCharacterUseCase(private val service: RickyMortyService) :
    BaseUseCase<GetDetailCharacterUseCase.Params, GetDetailCharacterUseCase.Result> {

    override suspend fun execute(params: Params): Result {
        return Result(service.getCharacterDetail(params.id))
    }

    data class Params(val id: Int)
    data class Result(val character: Character)
}