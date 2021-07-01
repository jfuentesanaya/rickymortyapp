package com.jfuentes.rickymortyapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jfuentes.rickymortyapp.core.BaseUseCase
import com.jfuentes.rickymortyapp.domain.model.Character
import com.jfuentes.rickymortyapp.domain.usecase.GetCharacterListUseCase
import com.jfuentes.rickymortyapp.presentation.adapter.CharacterAdapter
import kotlinx.coroutines.launch

/**
 * Created by Juan Fuentes on 29/06/2021.
 */
class ListVM (private val useCase: GetCharacterListUseCase): ViewModel() {

    val list  = emptyList<Character>()
    val adapter = CharacterAdapter()

    init {
        viewModelScope.launch {
            adapter.updateCharacters( useCase.execute(BaseUseCase.NoParameter).character)
        }
    }
}