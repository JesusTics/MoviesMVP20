package com.aether.moviesmvp20.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.aether.moviesmvp20.model.MovieRepository
import com.aether.moviesmvp20.utilities.Resource
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class MovieViewModel(private val repo:MovieRepository):ViewModel() {

    fun fetchMovies()=liveData(Dispatchers.IO){
        emit(Resource.Loading())
        try {
            emit(Resource.Success(repo.getMovies()))
        }catch (e: Exception){
            emit(Resource.Failure(e))
        }
    }
}

class MovieViewModelFactory(private val repo:MovieRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass:Class<T>):T{
        return modelClass.getConstructor(MovieRepository::class.java).newInstance(repo)
    }
}