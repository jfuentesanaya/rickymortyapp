package com.jfuentes.rickymortyapp.domain

import com.jfuentes.rickymortyapp.domain.usecase.GetFavouriteByIdUseCase
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test

/**
 * Created by Juan Fuentes on 05/07/2021.
 */
class GetFavouriteByIdUseCaseTest {

    private val repo = mockk<FavouritesRepo>(relaxed = true)

    @Test
    fun `should call exist favourite in repo when usecase is executed`() = runBlocking {
        val sut = GetFavouriteByIdUseCase(repo)
        sut.execute(GetFavouriteByIdUseCase.Params(1))
        coVerify(exactly = 1) { repo.existFavourite(1) }
    }
}