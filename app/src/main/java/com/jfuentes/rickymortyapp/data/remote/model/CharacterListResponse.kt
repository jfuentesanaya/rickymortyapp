package com.jfuentes.rickymortyapp.data.remote.model

import com.google.gson.annotations.SerializedName

data class CharacterListResponse(
    val info: Info,
    val results: List<CharacterResponse>
)

data class Info(
    val count: Int,
    val next: String,
    val pages: Int,
    val prev: Any
)

data class LocationResponse(
    val name: String,
    val url: String
)

data class CharacterResponse(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    @SerializedName("origin")
    val originLocation: LocationResponse,
    @SerializedName("location")
    val currentLocation: LocationResponse,
    val image: String,
    val episode: List<String>,
    val url: String,
    val created: String
)