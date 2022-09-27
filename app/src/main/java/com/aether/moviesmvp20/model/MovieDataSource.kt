package com.aether.moviesmvp20.model

import com.aether.moviesmvp20.utilities.Utilities


class MovieDataSource(private val webService: WebService) {
    suspend fun getMovies():MovieList{
        return webService.getMovies(Utilities.API_KEY)
    }
}