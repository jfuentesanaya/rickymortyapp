package com.jfuentes.rickymortyapp.data.remote

import com.jfuentes.rickymortyapp.data.remote.model.*
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import retrofit2.mock.Calls

/**
 * Created by Juan Fuentes on 28/06/2021.
 */
class RickyMortyServiceTest {

    private val api = mockk<RickyMortyAPI>(relaxed = true)
    private val service = RickyMortyServiceImpl(api)
    private val fakeListResponse = mockk<CharacterListResponse>(relaxed  = true)

    @Test
    fun `should call getCharactersList api when service is executed`() = runBlocking {
        coEvery { api.getCharacters() } returns Calls.response(fakeListResponse)
        service.getCharacterList()
        coVerify(exactly = 1) { api.getCharacters() }
    }

    @Test
    fun `should call getCharactersDetail api when service is executed`() = runBlocking {
        coEvery { api.getCharacterDetail(1) } returns Calls.response(fakeResponseObject)

        service.getCharacterDetail(1)
        coVerify(exactly = 1) { api.getCharacterDetail(1) }
    }

    @Test
    fun `should return data object mapped to domain when service is called`() = runBlocking {
        coEvery { api.getCharacterDetail(1) } returns Calls.response(fakeResponseObject)

        val dataCharacterMapper = fakeResponseObject.toCharacter()
        val domainCharacter = service.getCharacterDetail(1)

        Assert.assertEquals(dataCharacterMapper.id, domainCharacter.id)
        Assert.assertEquals(dataCharacterMapper.name, domainCharacter.name)
        Assert.assertEquals(dataCharacterMapper.status, domainCharacter.status)
        Assert.assertEquals(dataCharacterMapper.species, domainCharacter.species)
    }

    private val fakeResponseObject = CharacterResponse(
        1,
        "Rick",
        "alive",
        "human",
        "",
        "male",
        LocationResponse("earth", ""),
        LocationResponse("earth2", ""),
        "http://myfakeimage",
        emptyList(),
        "url",
        ""
    )
}