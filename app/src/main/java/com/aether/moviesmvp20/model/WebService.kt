package com.aether.moviesmvp20.model

import com.aether.moviesmvp20.utilities.Utilities
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {
    @GET("movie/popular")
    suspend fun getMovies(@Query("api_key")apiKey:String):MovieList
}

object RetrofitClient{
    val webService by lazy {
        Retrofit.Builder()
            .baseUrl(Utilities.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(WebService::class.java)
    }
}