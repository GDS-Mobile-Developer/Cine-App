package com.gdsdevtec.cineapp.presenter.model

import android.os.Parcelable
import com.gdsdevtec.cineapp.domain.model.Movie
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GenrePresentation(
    val id: Int?,
    val name: String?,
    val movies: List<Movie>,
) : Parcelable
