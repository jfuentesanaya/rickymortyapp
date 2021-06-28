package com.jfuentes.rickymortyapp.data.remote

import com.jfuentes.rickymortyapp.data.remote.model.CharacterResponse
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test

/**
 * Created by Juan Fuentes on 28/06/2021.
 */
class RickyMortyServiceTest {

    private val api = mockk<RickyMortyAPI>()
    private val service = RickyMortyServiceImpl(api)

    @Test
    fun `should call getCharactersList api when service is executed`() = runBlocking {
        coEvery { service.getCharacterList() } returns emptyList()
        service.getCharacterList()
        coVerify(exactly = 1) { api.getCharacters() }
    }

    @Test
    fun `should call getCharactersDetail api when service is executed`() = runBlocking {
        val fakeCharacter = mockk<CharacterResponse>()
        coEvery { service.getCharacterDetail(1) } returns fakeCharacter

        service.getCharacterDetail(1)
        coVerify(exactly = 1) { api.getCharacterDetail(1) }
    }
}