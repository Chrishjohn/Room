package com.svdroid.mymems.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.svdroid.mymems.model.Meme

@Database(entities = [Meme::class], version = 1)
abstract class MemsDatabase : RoomDatabase() {
    abstract fun memDao(): MemsDao
    companion object {
        @Volatile
        private var INSTANCE: MemsDatabase?=null
       fun getDatabase(context:Context):MemsDatabase
        {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(context,MemsDatabase::class.java,"MemsDB").build()
                }
            }
            return INSTANCE!!
        }
    }

}