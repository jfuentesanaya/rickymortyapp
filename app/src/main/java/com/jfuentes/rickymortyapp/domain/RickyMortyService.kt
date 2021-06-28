package com.jfuentes.rickymortyapp.domain

import com.jfuentes.rickymortyapp.data.remote.model.CharacterListResponse
import com.jfuentes.rickymortyapp.data.remote.model.CharacterResponse

/**
 * Created by Juan Fuentes on 28/06/2021.
 */
interface RickyMortyService {

    suspend fun getCharacterList(): List<CharacterResponse>

    suspend fun getCharacterDetail(characterId: Int): CharacterResponse
}