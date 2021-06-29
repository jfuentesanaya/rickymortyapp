package com.jfuentes.rickymortyapp.core

/**
 * Created by Juan Fuentes on 28/06/2021.
 */
interface BaseUseCase <in ParamsType: Any, out ResultType :Any> {

    suspend fun execute(params: ParamsType) : ResultType

    object  NoParameter
}