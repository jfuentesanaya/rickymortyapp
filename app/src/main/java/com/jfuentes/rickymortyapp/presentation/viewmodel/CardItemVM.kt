package com.jfuentes.rickymortyapp.presentation.viewmodel

import android.view.View
import androidx.lifecycle.ViewModel
import com.jfuentes.rickymortyapp.R
import com.jfuentes.rickymortyapp.domain.model.Character
import com.jfuentes.rickymortyapp.presentation.activities.DetailActivity

/**
 * Created by Juan Fuentes on 30/06/2021.
 */
class CardItemVM(private val character: Character) : ViewModel() {

    val name: String = character.name
    val imageUrl = character.image
    val placeholderImage = R.drawable.img_not_available
    val isFavourite = character.isFavourite

    fun onClickItem(view: View) {
        view.context.startActivity(DetailActivity.getCallingIntent(view.context, character))
    }
}