package com.gdsdevtec.cineapp.presenter.main.bottombar.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gdsdevtec.cineapp.BuildConfig
import com.gdsdevtec.cineapp.databinding.MovieItemBinding
import com.gdsdevtec.cineapp.domain.model.Movie

class MovieAdapter(
    private val context: Context,
) : ListAdapter<Movie, MovieAdapter.MovieViewHolder>(DIFF_CALLBACK) {
    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(
                oldItem: Movie,
                newItem: Movie,
            ) = oldItem.id == newItem.id

            override fun areContentsTheSame(
                oldItem: Movie,
                newItem: Movie,
            ) = oldItem == newItem
        }
    }

    inner class MovieViewHolder(val binding: MovieItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            MovieItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val item = getItem(position)
        Glide
             .with(context)
            .load("${BuildConfig.BASE_URL_IMAGE}${item.posterPath }")
            .into(holder.binding.movieImage)
    }


}