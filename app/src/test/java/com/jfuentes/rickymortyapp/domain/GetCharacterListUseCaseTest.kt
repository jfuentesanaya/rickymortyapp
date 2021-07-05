package com.jfuentes.rickymortyapp.domain

import com.jfuentes.rickymortyapp.core.BaseUseCase
import com.jfuentes.rickymortyapp.domain.usecase.GetCharacterListUseCase
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test

/**
 * Created by Juan Fuentes on 05/07/2021.
 */
class GetCharacterListUseCaseTest {

    private val service = mockk<RickyMortyService>(relaxed = true)

    @Test
    fun `should call get character list service when usecase is executed`() = runBlocking {
        val sut = GetCharacterListUseCase(service)

        sut.execute(BaseUseCase.NoParameter)
        coVerify(exactly = 1) { service.getCharacterList() }
    }
}