package com.jfuentes.rickymortyapp.presentation.viewmodel

import android.view.View
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableInt
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jfuentes.rickymortyapp.R
import com.jfuentes.rickymortyapp.domain.model.Character
import com.jfuentes.rickymortyapp.domain.model.toFavouriteCharacter
import com.jfuentes.rickymortyapp.domain.usecase.AddCharacterToFavouriteUseCase
import com.jfuentes.rickymortyapp.domain.usecase.GetFavouriteByIdUseCase
import com.jfuentes.rickymortyapp.domain.usecase.RemoveItemFromFavouriteUseCase
import kotlinx.coroutines.launch

/**
 * Created by Juan Fuentes on 01/07/2021.
 */
class CharacterDetailVM(
    val character: Character,
    private val getFavByIdUseCase: GetFavouriteByIdUseCase,
    private val addCharacterToFavouriteUseCase: AddCharacterToFavouriteUseCase,
    private val removeItemFromFavouriteUseCase: RemoveItemFromFavouriteUseCase
) : ViewModel() {

    private val isFavourite = ObservableBoolean(false)
    val imageFav = ObservableInt(R.drawable.ic_favorites_outline)

    init {
        checkIfCharacterIsFavourite()
    }

    fun onClickFavourite(view: View) {
        viewModelScope.launch {
            if (isFavourite.get()) {
                removeItemFromFavourites()
            }
            else {
                addItemToFavourite()
            }
        }
    }

    private suspend fun removeItemFromFavourites() {
        removeItemFromFavouriteUseCase.execute(
            RemoveItemFromFavouriteUseCase.Params(
                character.toFavouriteCharacter()
            )
        )
        isFavourite.set(false)
        imageFav.set(R.drawable.ic_favorites_outline)
    }

    private suspend fun addItemToFavourite(){
        addCharacterToFavouriteUseCase.execute(
            AddCharacterToFavouriteUseCase.Params(
                character.toFavouriteCharacter()
            )
        )
        isFavourite.set(true)
        imageFav.set(R.drawable.ic_favorites_filled)
    }

    private fun checkIfCharacterIsFavourite() {
        val idCharacter = GetFavouriteByIdUseCase.Params(character.id)
        viewModelScope.launch {
            val result = getFavByIdUseCase.execute(idCharacter).value
            isFavourite.set(result)
            if(result) imageFav.set(R.drawable.ic_favorites_filled)
        }
    }
}