package com.svdroid.mymems

import android.app.Application
import com.svdroid.mymems.APIServices.APIInterface
import com.svdroid.mymems.APIServices.ApiUtilities
import com.svdroid.mymems.db.MemsDatabase
import com.svdroid.mymems.repository.MainRepository

class MemsApplication : Application() {
    lateinit var mainRepository: MainRepository
    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {

        val apiInterface = ApiUtilities.getInstance().create(APIInterface::class.java)
        val database = MemsDatabase.getDatabase(applicationContext)
         mainRepository = MainRepository(apiInterface, database)
    }
}