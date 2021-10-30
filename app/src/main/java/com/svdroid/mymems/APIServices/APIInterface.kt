package com.svdroid.mymems.APIServices

import com.svdroid.mymems.model.MemsData
import retrofit2.Response
import retrofit2.http.GET

interface APIInterface {
    @GET("/get_memes")
    suspend fun getMems():Response<MemsData>
}