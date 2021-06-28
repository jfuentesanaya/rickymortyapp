package com.jfuentes.rickymortyapp.domain

import com.jfuentes.rickymortyapp.domain.model.Character

/**
 * Created by Juan Fuentes on 28/06/2021.
 */
interface RickyMortyService {

    suspend fun getCharacterList(): List<Character>

    suspend fun getCharacterDetail(characterId: Int): Character
}