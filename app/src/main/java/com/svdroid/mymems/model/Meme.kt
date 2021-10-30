package com.svdroid.mymems.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Mems")
data class Meme(
    val box_count: Int,
    val height: Int,
    @PrimaryKey
    val id: Int,
    val name: String,
    val url: String,
    val width: Int
)