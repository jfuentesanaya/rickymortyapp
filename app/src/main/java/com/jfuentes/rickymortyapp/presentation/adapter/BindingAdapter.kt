package com.jfuentes.rickymortyapp.presentation.adapter

import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.jfuentes.rickymortyapp.domain.model.Character
import com.squareup.picasso.Picasso


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

@BindingAdapter(value = ["imageUrl", "placeholderImage"], requireAll = false)
fun ImageView.setImage(url: String, @DrawableRes placeholder: Int?) {
    val picasso = Picasso.get().load(url)
    if (placeholder != null) {
        picasso.placeholder(placeholder)
    }
    picasso.into(this)
}

@BindingAdapter("fab_image")
fun FloatingActionButton.setImage(@DrawableRes image:Int){
    setImageResource(image);
}
