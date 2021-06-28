package com.jfuentes.rickymortyapp.data.remote

import com.jfuentes.rickymortyapp.data.remote.model.CharacterResponse
import com.jfuentes.rickymortyapp.domain.RickyMortyService

/**
 * Created by Juan Fuentes on 28/06/2021.
 */
class RickyMortyServiceImpl(private val rickyMortyAPI: RickyMortyAPI) : RickyMortyService {

    override suspend fun getCharacterList(): List<CharacterResponse> {
        return rickyMortyAPI.getCharacters().results
    }

    override suspend fun getCharacterDetail(characterId: Int): CharacterResponse {
        return rickyMortyAPI.getCharacterDetail(characterId)
    }
}