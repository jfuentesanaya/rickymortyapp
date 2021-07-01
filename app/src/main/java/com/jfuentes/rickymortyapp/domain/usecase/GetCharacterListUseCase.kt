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
class GetCharacterListUseCase (private val service: RickyMortyService, private val dispatcher: CoroutineDispatcher = Dispatchers.IO) :
    BaseUseCase<BaseUseCase.NoParameter, Result<List<Character>>> {

    override suspend fun execute(params: BaseUseCase.NoParameter): Result<List<Character>> {
        return executeService(dispatcher) {
            service.getCharacterList()
        }
    }

}