package com.aether.moviesmvp20.model

class MovieRepositoryImpl(private val dataSource:MovieDataSource):MovieRepository {

    override suspend fun getMovies(): MovieList = dataSource.getMovies()
}