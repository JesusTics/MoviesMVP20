package com.aether.moviesmvp20.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.aether.moviesmvp20.R
import com.aether.moviesmvp20.databinding.FragmentMovieMainBinding
import com.aether.moviesmvp20.model.*
import com.aether.moviesmvp20.presentation.MovieViewModel
import com.aether.moviesmvp20.presentation.MovieViewModelFactory
import com.aether.moviesmvp20.utilities.Resource
import com.facebook.drawee.backends.pipeline.Fresco

class MovieMainFragment : Fragment(R.layout.fragment_movie_main), MovieAdapter.OnMovieClickListener {

    private lateinit var binding:FragmentMovieMainBinding
    private val viewModel by viewModels<MovieViewModel> { MovieViewModelFactory(MovieRepositoryImpl(
        MovieDataSource(RetrofitClient.webService)
    )) }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Fresco.initialize(context)

        binding = FragmentMovieMainBinding.bind(view)



        viewModel.fetchMovies().observe(viewLifecycleOwner, Observer { result ->
            when(result){
                is Resource.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    val adapter = MovieAdapter(result.data.results,this@MovieMainFragment)
                    binding.listMovies.adapter=adapter


                    binding.progressBar.visibility = View.GONE
                    Log.d("LiveData","${result.data}")
                }
                is Resource.Failure -> {
                    binding.progressBar.visibility = View.GONE
                    Log.d("Error","${result.exception}")
                }
            }
        })
    }

    override fun onMovieClick(movie: Movie) {
        Log.d("Movie","${movie}")
    }
}