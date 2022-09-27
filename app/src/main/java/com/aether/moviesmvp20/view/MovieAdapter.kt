package com.aether.moviesmvp20.view

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.aether.moviesmvp20.databinding.MovieRowBinding
import com.aether.moviesmvp20.model.Movie
import com.aether.moviesmvp20.model.MovieList
import com.aether.moviesmvp20.utilities.BaseViewHolder
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.drawee.view.SimpleDraweeView

class MovieAdapter(
    private val movieList: List<Movie>,
    private val itemClickListener: OnMovieClickListener
) : RecyclerView.Adapter<BaseViewHolder<*>>() {

    interface OnMovieClickListener {
        fun onMovieClick(movie: Movie)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding =
            MovieRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val holder = MoviesViewHolder(itemBinding, parent.context)

        itemBinding.root.setOnClickListener {
            val position = holder.adapterPosition.takeIf { it != DiffUtil.DiffResult.NO_POSITION }
                ?: return@setOnClickListener
            itemClickListener.onMovieClick((movieList[position]))
        }
        return holder
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is MoviesViewHolder -> holder.bind(movieList[position])
        }
    }

    override fun getItemCount(): Int = movieList.size


    private inner class MoviesViewHolder(
        val binding: MovieRowBinding,
        val context: Context
    ) : BaseViewHolder<Movie>(binding.root) {
        override fun bind(item: Movie) {
            val url = "https://image.tmdb.org/t/p/w500${item.poster_path}"
            Fresco.initialize(context)
            val imageUri: Uri = Uri.parse(url)
            val draweeView = binding.imgPosterMovie
            draweeView.setImageURI(imageUri)

            binding.txtTitleMovie.text = item.title
            binding.txtLanguageMovie.text = "Original lenguage: ${item.original_language}"
            binding.txtPopularityMovie.text = "Votes: ${item.popularity}  Popularity (${item.vote_average})"
            binding.txtReleaseDateMovie.text = "Release date: ${item.release_date}"
        }
    }
}
