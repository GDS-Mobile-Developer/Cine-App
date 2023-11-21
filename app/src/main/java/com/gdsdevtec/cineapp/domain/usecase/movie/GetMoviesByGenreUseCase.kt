package com.gdsdevtec.cineapp.domain.usecase.movie

import com.gdsdevtec.cineapp.data.mapper.toMovie
import com.gdsdevtec.cineapp.domain.repository.movie.MovieRepository
import javax.inject.Inject

class GetMoviesByGenreUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
) {
    suspend operator fun invoke(
        apiKey: String,
        language: String?,
        genreId: Int?,
    ) = movieRepository.getMoviesByGenre(
        apiKey, language, genreId
    ).map { it.toMovie() }
}