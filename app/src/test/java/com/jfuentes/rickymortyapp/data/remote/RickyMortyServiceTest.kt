package com.jfuentes.rickymortyapp.data.remote

import com.jfuentes.rickymortyapp.data.remote.model.CharacterResponse
import com.jfuentes.rickymortyapp.data.remote.model.LocationResponse
import com.jfuentes.rickymortyapp.data.remote.model.toCharacter
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

/**
 * Created by Juan Fuentes on 28/06/2021.
 */
class RickyMortyServiceTest {

    private val api = mockk<RickyMortyAPI>()
    private val service = RickyMortyServiceImpl(api)

    @Test
    fun `should call getCharactersList api when service is executed`() = runBlocking {
        coEvery { api.getCharacters().results } returns listOf(fakeResponseObject)
        service.getCharacterList()
        coVerify(exactly = 1) { api.getCharacters() }
    }

    @Test
    fun `should call getCharactersDetail api when service is executed`() = runBlocking {
        coEvery { api.getCharacterDetail(1) } returns fakeResponseObject

        service.getCharacterDetail(1)
        coVerify(exactly = 1) { api.getCharacterDetail(1) }
    }

    @Test
    fun `should return data object mapped to domain when service is called`()  = runBlocking{
        coEvery { api.getCharacterDetail(1) } returns fakeResponseObject

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