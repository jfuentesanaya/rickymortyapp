package com.jfuentes.rickymortyapp.data.remote.model

import com.jfuentes.rickymortyapp.domain.model.Character
import com.jfuentes.rickymortyapp.domain.model.Location

/**
 * Created by Juan Fuentes on 28/06/2021.
 */

fun CharacterResponse.toCharacter() = Character(
    id,
    name,
    status,
    species,
    type,
    gender,
    originLocation.toLocation(),
    currentLocation.toLocation(),
    image,
    url,
    created
)


private fun LocationResponse.toLocation() = Location(name, url)
