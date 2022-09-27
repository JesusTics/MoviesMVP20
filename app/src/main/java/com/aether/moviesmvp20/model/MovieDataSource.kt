package com.aether.moviesmvp20.model

class MovieDataSource {
    fun getMovies():MovieList{
        return MovieList()
    }
}