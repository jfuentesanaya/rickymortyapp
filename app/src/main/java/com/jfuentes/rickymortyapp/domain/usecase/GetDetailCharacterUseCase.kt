package com.jfuentes.rickymortyapp.domain.usecase

import com.jfuentes.rickymortyapp.core.BaseUseCase
import com.jfuentes.rickymortyapp.core.Result
import com.jfuentes.rickymortyapp.core.executeService
import com.jfuentes.rickymortyapp.domain.RickyMortyService
import com.jfuentes.rickymortyapp.domain.model.Character
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

/**
 * Created by Juan Fuentes on 28/06/2021.
 */
class GetDetailCharacterUseCase(private val service: RickyMortyService, private val dispatcher: CoroutineDispatcher = Dispatchers.IO) :
    BaseUseCase<GetDetailCharacterUseCase.Params, Result<Character>> {

    override suspend fun execute(params: Params): Result<Character> {
        return executeService(dispatcher) {
            service.getCharacterDetail(params.id)
        }
    }

    data class Params(val id: Int)
}