package com.jfuentes.rickymortyapp.domain.model

/**
 * Created by Juan Fuentes on 02/07/2021.
 */

fun Character.toFavouriteCharacter() = FavouriteCharacter(id, name, image)