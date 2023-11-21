package com.gdsdevtec.cineapp.data.repository.movie

import com.gdsdevtec.cineapp.data.api.ServiceApi
import com.gdsdevtec.cineapp.domain.repository.movie.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val serviceApi: ServiceApi,
) : MovieRepository {
    override suspend fun getGenres(
        apiKey: String,
        language: String?,
    ) = serviceApi.getGenres(apiKey, language)

    override suspend fun getMoviesByGenre(
        apiKey: String,
        language: String?,
        withGenreId: Int,
    ) = serviceApi.getMoviesByGenre(
        apiKey, language, withGenreId
    ).results ?: emptyList()
}