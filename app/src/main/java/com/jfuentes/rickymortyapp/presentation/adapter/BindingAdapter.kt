package com.jfuentes.rickymortyapp.presentation.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jfuentes.rickymortyapp.domain.model.Character


/**
 * Created by Juan Fuentes on 30/06/2021.
 */

@BindingAdapter("data")
fun RecyclerView.setRecyclerViewProperties(data: MutableList<Character>) {
    val adapter = adapter
    if (adapter is CharacterAdapter) {
        adapter.updateCharacters(data)
    }
}

@BindingAdapter("adapter")
fun RecyclerView.setAdapter(adapter: CharacterAdapter) {
    this.adapter = adapter
}
