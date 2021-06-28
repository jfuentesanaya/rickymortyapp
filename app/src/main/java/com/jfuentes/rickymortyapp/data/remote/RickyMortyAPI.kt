package com.jfuentes.rickymortyapp.data.remote

import com.jfuentes.rickymortyapp.data.remote.model.CharacterListResponse
import com.jfuentes.rickymortyapp.data.remote.model.CharacterResponse
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Juan Fuentes on 28/06/2021.
 */
interface RickyMortyAPI {

    @GET("character")
    fun getCharacters() : CharacterListResponse

    @GET("character/{characterId}")
    fun getCharacterDetail(@Path("characterId") characterId: Int) : CharacterResponse

}