package com.gdsdevtec.cineapp.presenter.auth.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.gdsdevtec.cineapp.domain.usecase.auth.LoginUseCase
import com.gdsdevtec.cineapp.utils.StateView
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject
@HiltViewModel
class LoginViewModel @Inject constructor(
    private val useCase: LoginUseCase,
) : ViewModel() {

    fun login(
        email: String,
        password: String,
    ) = liveData(Dispatchers.IO) {
        try {
            emit(StateView.Loading)
            useCase(email, password)
            emit(StateView.Success(data = Unit, msg = null))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(StateView.Success(data = null, msg = e.message))
        }
    }
}