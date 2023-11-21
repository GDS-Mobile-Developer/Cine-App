package com.gdsdevtec.cineapp.data.api

import com.gdsdevtec.cineapp.data.model.BasePaginationRemote
import com.gdsdevtec.cineapp.data.model.GenreResponse
import com.gdsdevtec.cineapp.data.model.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceApi {
    @GET("genre/movie/list")
    suspend fun getGenres(
        @Query("api_key") apiKey: String,
        @Query("language") language: String?,
    ): GenreResponse

    @GET("discover/movie")
    suspend fun getMoviesByGenre(
        @Query("api_key") apiKey: String,
        @Query("language") language: String?,
        @Query("with_genres") withGenreId: Int,
    ): BasePaginationRemote<List<MovieResponse>>

}