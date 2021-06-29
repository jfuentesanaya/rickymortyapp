package com.jfuentes.rickymortyapp.data.remote

import com.jfuentes.rickymortyapp.data.remote.model.toCharacter
import com.jfuentes.rickymortyapp.domain.model.Character
import com.jfuentes.rickymortyapp.domain.RickyMortyService
import retrofit2.await

/**
 * Created by Juan Fuentes on 28/06/2021.
 */
class RickyMortyServiceImpl(private val rickyMortyAPI: RickyMortyAPI) : RickyMortyService {

    override suspend fun getCharacterList(): List<Character> {
        return rickyMortyAPI.getCharacters().await().results.map {
            it.toCharacter()
        }
    }

    override suspend fun getCharacterDetail(characterId: Int): Character {
        return rickyMortyAPI.getCharacterDetail(characterId).await().toCharacter()
    }
}