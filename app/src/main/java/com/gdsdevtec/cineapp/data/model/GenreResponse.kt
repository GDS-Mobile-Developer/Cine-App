package com.gdsdevtec.cineapp.data.model

import com.google.gson.annotations.SerializedName

data class GenreResponse(
    @SerializedName("genres")
    val genres : List<GenreItemResponse>?
)
