package com.jfuentes.rickymortyapp.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity

/**
 * Created by Juan Fuentes on 01/07/2021.
 */

@Entity(primaryKeys= [ "id", "name" ] )
data class FavouriteEntity(
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "name") val name: String
)