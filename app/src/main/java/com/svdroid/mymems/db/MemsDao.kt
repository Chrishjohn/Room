package com.svdroid.mymems.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.svdroid.mymems.model.Meme

@Dao
interface MemsDao {
    @Insert
    suspend fun addMems(mems: List<Meme>)
    @Query("SELECT * FROM mems")
    suspend fun getMems(): List<Meme>
}