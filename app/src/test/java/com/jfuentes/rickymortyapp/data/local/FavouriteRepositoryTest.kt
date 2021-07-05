package com.jfuentes.rickymortyapp.data.local

import com.jfuentes.rickymortyapp.data.FavouritesRepoImpl
import com.jfuentes.rickymortyapp.data.local.model.FavouriteEntity
import com.jfuentes.rickymortyapp.data.toFavoriteEntity
import com.jfuentes.rickymortyapp.data.toFavouriteCharacter
import com.jfuentes.rickymortyapp.domain.model.FavouriteCharacter
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

/**
 * Created by Juan Fuentes on 05/07/2021.
 */
class FavouriteRepositoryTest {

    private val favouriteDAO = mockk<FavouriteDAO>(relaxed = true)
    private val repo = FavouritesRepoImpl(favouriteDAO)
    private val fakeFavCharacter = FavouriteCharacter(1, "Rick", "http://myfakeimage")

    @Test
    fun `should map correctly domain object to data object`() {
        val favEntity = fakeFavCharacter.toFavoriteEntity()
        Assert.assertEquals(fakeFavCharacter.id, favEntity.id)
        Assert.assertEquals(fakeFavCharacter.name, favEntity.name)
        Assert.assertEquals(fakeFavCharacter.image, favEntity.image)
    }

    @Test
    fun `should map correctly data object to domain object`() {
        val fakeFavEntity = FavouriteEntity(1, "Rick", "image")
        val favDomain = fakeFavEntity.toFavouriteCharacter()
        Assert.assertEquals(fakeFavEntity.id, favDomain.id)
        Assert.assertEquals(fakeFavEntity.name, favDomain.name)
        Assert.assertEquals(fakeFavEntity.image, favDomain.image)
    }

    @Test
    fun `should call insert dao when favourite is inserted in repo`() = runBlocking {
        repo.insertFavourite(fakeFavCharacter)
        coVerify (exactly = 1){ favouriteDAO.insert(fakeFavCharacter.toFavoriteEntity()) }
    }

    @Test
    fun `should call delete dao when favourite is deleted in repo`() = runBlocking {
        repo.delete(fakeFavCharacter)
        coVerify (exactly = 1) { favouriteDAO.delete(fakeFavCharacter.toFavoriteEntity()) }
    }

    @Test
    fun `should call findById dao when we find by id in repo`() = runBlocking {
        coEvery { favouriteDAO.findById(2) } returns FavouriteEntity(2, "Rick", "image")
        repo.findById(2)
        coVerify (exactly = 1){ favouriteDAO.findById(2) }
    }

    @Test
    fun `should call exist favourite method dao when we call them in repo`() = runBlocking {
        repo.existFavourite(2)
        coVerify (exactly = 1){ favouriteDAO.exists(2) }
    }

    @Test
    fun `should call getAll method dao when getAll repo is executed`() = runBlocking {
        repo.getAll()
        coVerify (exactly = 1){ favouriteDAO.getAll() }
    }

}