package com.jfuentes.rickymortyapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jfuentes.rickymortyapp.core.BaseUseCase
import com.jfuentes.rickymortyapp.domain.usecase.GetCharacterListUseCase
import kotlinx.coroutines.launch

/**
 * Created by Juan Fuentes on 29/06/2021.
 */
class ListVM (private val useCase: GetCharacterListUseCase): ViewModel() {

    init {
        viewModelScope.launch {
            useCase.execute(BaseUseCase.NoParameter)
        }

    }
}