package com.jfuentes.rickymortyapp.domain

import com.jfuentes.rickymortyapp.domain.model.FavouriteCharacter
import com.jfuentes.rickymortyapp.domain.usecase.AddCharacterToFavouriteUseCase
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test

/**
 * Created by Juan Fuentes on 05/07/2021.
 */
class AddCharacterToFavouriteUseCaseTest {

    private val repo = mockk<FavouritesRepo>(relaxed = true)

    @Test
    fun `should call insert favourite in repo when usecase is executed`() = runBlocking {
        val sut = AddCharacterToFavouriteUseCase(repo)
        val fakeFavourite = FavouriteCharacter(1, "Rick", "fakeimge")

        sut.execute(AddCharacterToFavouriteUseCase.Params(fakeFavourite))
        coVerify(exactly = 1) { repo.insertFavourite(fakeFavourite) }
    }
}