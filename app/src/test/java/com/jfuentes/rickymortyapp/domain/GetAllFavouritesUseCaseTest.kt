package com.jfuentes.rickymortyapp.domain

import com.jfuentes.rickymortyapp.core.BaseUseCase
import com.jfuentes.rickymortyapp.domain.usecase.GetAllFavouritesUseCase
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test

/**
 * Created by Juan Fuentes on 05/07/2021.
 */
class GetAllFavouritesUseCaseTest {

    private val repo = mockk<FavouritesRepo>(relaxed = true)

    @Test
    fun `should call getAll favourites repo when usecase is executed`() = runBlocking {
        val sut =  GetAllFavouritesUseCase(repo)

        sut.execute(BaseUseCase.NoParameter)
        coVerify(exactly = 1) { repo.getAll() }
    }
}