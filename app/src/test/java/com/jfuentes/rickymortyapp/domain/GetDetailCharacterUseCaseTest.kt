package com.jfuentes.rickymortyapp.domain

import com.jfuentes.rickymortyapp.domain.usecase.GetDetailCharacterUseCase
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test

/**
 * Created by Juan Fuentes on 05/07/2021.
 */
class GetDetailCharacterUseCaseTest {

    private val service = mockk<RickyMortyService>(relaxed = true)

    @Test
    fun `should call detail service when usecase is executed`() = runBlocking {
        val sut = GetDetailCharacterUseCase(service)

        sut.execute(GetDetailCharacterUseCase.Params(1))
        coVerify(exactly = 1) { service.getCharacterDetail(1) }
    }
}