package com.aether.moviesmvp20.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.aether.moviesmvp20.R
import com.aether.moviesmvp20.databinding.FragmentMovieMainBinding
import com.aether.moviesmvp20.model.*
import com.aether.moviesmvp20.presentation.MovieViewModel
import com.aether.moviesmvp20.presentation.MovieViewModelFactory
import com.aether.moviesmvp20.utilities.Resource

class MovieMainFragment : Fragment(R.layout.fragment_movie_main) {

    private lateinit var binding:FragmentMovieMainBinding
    private val viewModel by viewModels<MovieViewModel> { MovieViewModelFactory(MovieRepositoryImpl(
        MovieDataSource(RetrofitClient.webService)
    )) }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMovieMainBinding.bind(view)

        viewModel.fetchMovies().observe(viewLifecycleOwner, Observer { result ->
            when(result){
                is Resource.Loading -> {
                    Log.d("LiveData","Loading...")
                }
                is Resource.Success -> {
                    Log.d("LiveData","${result.data}")
                }
                is Resource.Failure -> {
                    Log.d("Error","${result.exception}")
                }
            }
        })
    }
}