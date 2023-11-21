package com.gdsdevtec.cineapp.presenter.main.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.gdsdevtec.cineapp.BuildConfig
import com.gdsdevtec.cineapp.data.mapper.toGenrePresentation
import com.gdsdevtec.cineapp.domain.usecase.movie.GetGenresUseCase
import com.gdsdevtec.cineapp.domain.usecase.movie.GetMoviesByGenreUseCase
import com.gdsdevtec.cineapp.utils.StateView
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getGenresUseCase: GetGenresUseCase,
    private val getMoviesByGenreUseCase: GetMoviesByGenreUseCase,
) : ViewModel() {

    fun getGenres() = liveData(Dispatchers.IO) {
        try {
            emit(StateView.Loading)
            val genres = getGenresUseCase(
                BuildConfig.API_KEY,
                LANGUAGE_REQUEST
            ).map { it.toGenrePresentation() }
            emit(StateView.Success(data = genres, msg = null))
        } catch (e: HttpException) {
            e.printStackTrace()
            e.message?.let { StateView.Error(it) }
        } catch (e: Exception) {
            e.printStackTrace()
            e.message?.let { StateView.Error(it) }
        }
    }

    private companion object{
        const val LANGUAGE_REQUEST = "pt-br"
    }
}