package com.jfuentes.rickymortyapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.jfuentes.rickymortyapp.R
import com.jfuentes.rickymortyapp.databinding.CharacterItemBinding
import com.jfuentes.rickymortyapp.domain.model.Character
import com.jfuentes.rickymortyapp.domain.model.FavouriteCharacter
import com.jfuentes.rickymortyapp.domain.model.toFavouriteCharacter
import com.jfuentes.rickymortyapp.presentation.viewmodel.CardItemVM

/**
 * Created by Juan Fuentes on 29/06/2021.
 */
class CharacterAdapter : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    private var values: List<Character> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {

        val binding: CharacterItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.character_item,
            parent,
            false
        )

        return CharacterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(values[position])
    }

    override fun getItemCount(): Int = values.size

    fun updateCharacters(characters: List<Character>) {
        values = characters
        notifyDataSetChanged()
    }

    fun setFavourites(characters: List<FavouriteCharacter>) {
        values.map {
            it.isFavourite = characters.contains(it.toFavouriteCharacter())
        }
        notifyDataSetChanged()
    }

    inner class CharacterViewHolder(private val binding: CharacterItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Character) {
            val itemVM = CardItemVM(item)
            binding.model = itemVM
        }
    }
}