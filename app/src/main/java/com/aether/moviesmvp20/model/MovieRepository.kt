package com.aether.moviesmvp20.model

interface MovieRepository {
    suspend fun getMovies():MovieList
}