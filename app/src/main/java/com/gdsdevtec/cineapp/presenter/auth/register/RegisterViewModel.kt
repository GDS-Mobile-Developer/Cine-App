package com.gdsdevtec.cineapp.presenter.auth.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.gdsdevtec.cineapp.domain.usecase.auth.RegisterUseCase
import com.gdsdevtec.cineapp.utils.StateView
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val useCase: RegisterUseCase,
) : ViewModel() {
    fun register(
        email: String,
        password: String,
    ) = liveData(Dispatchers.IO) {
        try {
            emit(StateView.Loading)
            useCase(email, password)
            emit(StateView.Success(data = Unit, msg = null))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(StateView.Error("${e.message}"))
        }
    }
}