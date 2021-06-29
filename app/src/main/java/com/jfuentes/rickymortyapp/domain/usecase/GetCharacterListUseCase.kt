package com.jfuentes.rickymortyapp.domain.usecase

import com.jfuentes.rickymortyapp.core.BaseUseCase
import com.jfuentes.rickymortyapp.domain.RickyMortyService
import com.jfuentes.rickymortyapp.domain.model.Character

/**
 * Created by Juan Fuentes on 28/06/2021.
 */
class GetCharacterListUseCase (private val service: RickyMortyService) :
    BaseUseCase<BaseUseCase.NoParameter, GetCharacterListUseCase.Result> {

    override suspend fun execute(params: BaseUseCase.NoParameter): Result {
        return Result(service.getCharacterList())
    }


    data class Result(val character: List<Character>)
}