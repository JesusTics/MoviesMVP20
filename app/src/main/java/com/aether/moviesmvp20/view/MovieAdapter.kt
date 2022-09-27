package com.aether.moviesmvp20.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aether.moviesmvp20.databinding.FragmentMovieMainBinding
import com.aether.moviesmvp20.databinding.MovieRowBinding
import com.aether.moviesmvp20.model.Movie
import com.aether.moviesmvp20.utilities.BaseViewHolder

class MovieAdapter:RecyclerView.Adapter<BaseViewHolder<*>>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding = MovieRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    private inner class MoviesViewHolder(val binding: MovieRowBinding):BaseViewHolder<Movie>(binding.root){
        override fun bind(item: Movie) {
            
        }
    }
}