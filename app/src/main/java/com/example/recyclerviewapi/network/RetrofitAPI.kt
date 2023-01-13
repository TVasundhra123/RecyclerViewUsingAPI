package com.example.recyclerviewapi.network

import com.example.recyclerviewapi.recyclerView.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitAPI {
    @GET("/")
    suspend fun getMoviesData(
        @Query("s") tag: String,
        @Query("apikey") apiKey: String = "f7dc1c21"
    ): Response<MovieResponse>
}