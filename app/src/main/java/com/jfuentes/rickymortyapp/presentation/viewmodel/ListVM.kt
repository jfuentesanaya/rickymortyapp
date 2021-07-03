package com.jfuentes.rickymortyapp.presentation.viewmodel

import android.view.View
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jfuentes.rickymortyapp.R
import com.jfuentes.rickymortyapp.core.Result.*
import com.jfuentes.rickymortyapp.core.BaseUseCase
import com.jfuentes.rickymortyapp.domain.model.Character
import com.jfuentes.rickymortyapp.domain.usecase.GetAllFavouritesUseCase
import com.jfuentes.rickymortyapp.domain.usecase.GetCharacterListUseCase
import com.jfuentes.rickymortyapp.presentation.adapter.CharacterAdapter
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * Created by Juan Fuentes on 29/06/2021.
 */
class ListVM (private val getCharacterListUseCase: GetCharacterListUseCase, private val getAllFavouritesUseCase: GetAllFavouritesUseCase): ViewModel() {

    val adapter = CharacterAdapter()
    val progressVisibility = ObservableInt(View.GONE)
    val errorMessage = ObservableInt(R.string.network_error)
    val btnMessage = ObservableField(R.string.restart)
    val errorVisibility = ObservableInt(View.GONE)

    init {
        loadData()
    }

    private fun loadData() {
        progressVisibility.set(View.VISIBLE)
        viewModelScope.launch {
            when (val response = getCharacterListUseCase.execute(BaseUseCase.NoParameter)) {
                is NetworkError -> showErrorState(R.string.network_error)
                is GenericError -> showErrorState(R.string.generic_error)
                is Success -> showSuccessState(response)
            }

            getAllFavouritesUseCase.execute(BaseUseCase.NoParameter).collect {
                adapter.setFavourites(it)
            }
        }
    }

    private fun showErrorState(message: Int) {
        progressVisibility.set(View.GONE)
        errorVisibility.set(View.VISIBLE)
        errorMessage.set(message)
    }

    private fun showSuccessState(response: Success<List<Character>>) {
        progressVisibility.set(View.GONE)
        errorVisibility.set(View.GONE)
        adapter.updateCharacters(
            response.value
        )
    }

    fun onLoadClick(view: View) {
        loadData()
    }
}