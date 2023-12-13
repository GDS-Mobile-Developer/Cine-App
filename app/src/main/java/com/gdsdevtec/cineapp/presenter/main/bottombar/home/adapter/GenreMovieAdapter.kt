package com.gdsdevtec.cineapp.presenter.main.bottombar.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gdsdevtec.cineapp.databinding.GenreItemBinding
import com.gdsdevtec.cineapp.presenter.model.GenrePresentation

class GenreMovieAdapter(
    private val clickShowAll: (Int) -> Unit,
) : ListAdapter<GenrePresentation, GenreMovieAdapter.MovieViewHolder>(
    DIFF_CALLBACK
) {
    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<GenrePresentation>() {
            override fun areItemsTheSame(
                oldItem: GenrePresentation,
                newItem: GenrePresentation,
            ) = oldItem.id == newItem.id

            override fun areContentsTheSame(
                oldItem: GenrePresentation,
                newItem: GenrePresentation,
            ) = oldItem == newItem
        }
    }

    inner class MovieViewHolder(val binding: GenreItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            GenreItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.genreName.text = item.name
        val movieAdapter = MovieAdapter(holder.binding.root.context)
        holder.binding.rvGenreMovies.apply {
            adapter = movieAdapter
            setHasFixedSize(true)
        }
        holder.binding.textShowAll.setOnClickListener {
            item.id?.let{ clickShowAll.invoke(it) }
        }
        movieAdapter.submitList(item.movies)
    }
}