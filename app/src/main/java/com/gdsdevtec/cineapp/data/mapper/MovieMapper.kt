package com.gdsdevtec.cineapp.data.mapper

import com.gdsdevtec.cineapp.data.model.GenreItemResponse
import com.gdsdevtec.cineapp.data.model.MovieResponse
import com.gdsdevtec.cineapp.domain.model.GenreItem
import com.gdsdevtec.cineapp.domain.model.Movie
import com.gdsdevtec.cineapp.presenter.model.GenrePresentation

fun GenreItemResponse.toGenreItem() : GenreItem = GenreItem(
    id = this.id, name = this.name
)

fun MovieResponse.toMovie() : Movie = Movie(
    adult = this.adult,
    backdropPath = this.backdropPath,
    genreIds = this.genreIds,
    id = this.id,
    originalLanguage = this.originalLanguage,
    originalTitle = this.originalTitle,
    overview = this.overview,
    popularity = this.popularity,
    posterPath = this.posterPath,
    releaseDate = this.releaseDate,
    title = this.title,
    video = this.video,
    voteAverage = this.voteAverage,
    voteCount = this.voteCount
)

fun GenreItem.toGenrePresentation() : GenrePresentation = GenrePresentation(
    id = this.id, name = this.name, movies = emptyList()

)