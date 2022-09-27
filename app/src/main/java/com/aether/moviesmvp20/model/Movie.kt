package com.aether.moviesmvp20.model

data class Movie(
    val id: Int = -1,
    val poster_path: String = "",
    val title: String = "",
    val release_dateL: String = "",
    val popularity: Double =-1.0,
    val original_language: String = "",
    val vote_average: Double = -1.0
)


data class MovieList(val results:List<Movie> = listOf())
