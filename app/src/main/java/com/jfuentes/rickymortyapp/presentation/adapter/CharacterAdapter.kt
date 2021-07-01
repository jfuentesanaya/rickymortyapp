package com.jfuentes.rickymortyapp.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jfuentes.rickymortyapp.R
import com.jfuentes.rickymortyapp.domain.model.Character
import com.squareup.picasso.Picasso

/**
 * Created by Juan Fuentes on 29/06/2021.
 */
class CharacterAdapter(
    private val picasso: Picasso
) : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    private var values: List<Character> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.character_item, parent, false)
        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val item = values[position]

        holder.bind(item)
       /* holder.item.setOnClickListener {
            listener.onClickItem(item) }*/
    }

    override fun getItemCount(): Int = values.size

    fun updateCharacters(characters: List<Character>) {
        values = characters
        notifyDataSetChanged()
    }

    inner class CharacterViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val item: View = view.findViewById(R.id.item_layout)
        private val idView: TextView = view.findViewById(R.id.tv_name)
        val contentView: ImageView = view.findViewById(R.id.iv_character)

        fun bind(item: Character) {
            idView.text = item.name
            picasso.load(item.image).placeholder(R.drawable.img_not_available).into(contentView)
        }
    }

    interface OnClickCharacter {
        fun onClickItem(item: Character)
    }
}