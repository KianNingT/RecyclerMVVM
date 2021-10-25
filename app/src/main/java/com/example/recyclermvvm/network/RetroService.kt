package com.example.recyclermvvm.network

import com.example.recyclermvvm.models.RecyclerList
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroService {

    //using this function in coroutine
    @GET("repositories")
    suspend fun getDataFromApi(@Query("q") query: String): RecyclerList
}