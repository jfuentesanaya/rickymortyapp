package com.jfuentes.rickymortyapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Created by Juan Fuentes on 28/06/2021.
 */

@Parcelize
data class Location(
    val name: String,
    val url: String
) : Parcelable

@Parcelize
data class Character(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val originLocation: Location,
    val currentLocation: Location,
    val image: String,
    val url: String,
    val created: String,
    var isFavourite: Boolean = false
) : Parcelable
