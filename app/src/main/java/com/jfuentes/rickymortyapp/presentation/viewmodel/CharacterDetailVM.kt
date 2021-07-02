package com.jfuentes.rickymortyapp.presentation.viewmodel

import android.view.View
import androidx.databinding.ObservableInt
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jfuentes.rickymortyapp.R
import com.jfuentes.rickymortyapp.domain.model.Character
import com.jfuentes.rickymortyapp.domain.usecase.GetFavouriteByIdUseCase
import kotlinx.coroutines.launch

/**
 * Created by Juan Fuentes on 01/07/2021.
 */
class CharacterDetailVM(val character: Character, private val getFavByIdUseCase: GetFavouriteByIdUseCase) :
    ViewModel() {

    val imageFav = ObservableInt(R.drawable.ic_favorites_outline)

    init {
        checkIfCharacterIsFavourite()
    }

    fun onClickFavourite(view: View) {
    }

    private fun checkIfCharacterIsFavourite() {
        val idCharacter = GetFavouriteByIdUseCase.Params(character.id)
        viewModelScope.launch {
            if (getFavByIdUseCase.execute(idCharacter).value) {
                imageFav.set(R.drawable.ic_favorites_filled)
            }
        }
    }

}