package com.gdsdevtec.cineapp.domain.usecase.movie

import com.gdsdevtec.cineapp.data.mapper.toGenreItem
import com.gdsdevtec.cineapp.domain.repository.movie.MovieRepository
import javax.inject.Inject

class GetGenresUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
) {
    suspend operator fun invoke(
        apiKey: String,
        language: String?,
    ) = movieRepository.getGenres(
        apiKey, language
    ).genres?.map { it.toGenreItem() } ?: emptyList()
}