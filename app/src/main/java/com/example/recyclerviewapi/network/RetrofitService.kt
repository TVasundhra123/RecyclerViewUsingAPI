package com.example.recyclerviewapi.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitService {
    private lateinit var retrofitApi: RetrofitAPI

    fun getApiService(): RetrofitAPI {
        val logging = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        val baseUrl = "https://www.omdbapi.com"
        val okhttp = OkHttpClient.Builder().addInterceptor(logging)
        retrofitApi = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okhttp.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitAPI::class.java)

        return retrofitApi
    }
}