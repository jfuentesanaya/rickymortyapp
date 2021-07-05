package com.jfuentes.rickymortyapp.domain

import com.jfuentes.rickymortyapp.domain.model.FavouriteCharacter
import com.jfuentes.rickymortyapp.domain.usecase.RemoveItemFromFavouriteUseCase
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test

/**
 * Created by Juan Fuentes on 05/07/2021.
 */
class RemoveItemFromFavouriteUseCaseTest {

    private val repo = mockk<FavouritesRepo>(relaxed = true)

    @Test
    fun `should call remove favourite in repo when usecase is executed`() = runBlocking {
        val sut = RemoveItemFromFavouriteUseCase(repo)
        val fakeFav = FavouriteCharacter(1, "rick", "fakeimg")
        sut.execute(RemoveItemFromFavouriteUseCase.Params(fakeFav))
        coVerify(exactly = 1) { repo.delete(fakeFav) }
    }
}