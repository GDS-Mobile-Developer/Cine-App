package com.gdsdevtec.cineapp.domain.repository.movie

import com.gdsdevtec.cineapp.data.model.GenreResponse
import com.gdsdevtec.cineapp.data.model.MovieResponse

interface MovieRepository {
    suspend fun getGenres(
        apiKey: String,
        language: String?,
    ): GenreResponse
    suspend fun getMoviesByGenre(
        apiKey: String,
        language: String?,
        withGenreId: Int,
    ): List<MovieResponse>
}