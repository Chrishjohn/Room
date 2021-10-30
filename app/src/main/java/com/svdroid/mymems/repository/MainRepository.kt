package com.svdroid.mymems.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.svdroid.mymems.APIServices.APIInterface
import com.svdroid.mymems.db.MemsDatabase
import com.svdroid.mymems.model.Data
import com.svdroid.mymems.model.MemsData

class MainRepository(
    private val apiInterface: APIInterface,
    private val memsDatabase: MemsDatabase
) {
    private val memsLiveData = MutableLiveData<MemsData>()
    val mems: LiveData<MemsData>
        get() = memsLiveData

    suspend fun getMems() {
        if (memsDatabase.memDao().getMems().isEmpty()) {
            val result = apiInterface.getMems()
            if (result.body() != null) {
                memsDatabase.memDao().addMems(result.body()!!.data.memes)
                val mem = MemsData(Data(result.body()!!.data.memes), true)
                memsLiveData.postValue(mem)
            }
        } else {
            val mem = MemsData(Data(memsDatabase.memDao().getMems()), true)
            memsLiveData.postValue(mem)

        }
    }
}