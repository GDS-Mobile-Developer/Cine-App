package com.gdsdevtec.cineapp.presenter.auth.forgot

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.gdsdevtec.cineapp.domain.usecase.auth.ForgotUseCase
import com.gdsdevtec.cineapp.utils.StateView
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class ForgotViewModel @Inject constructor(
    private val useCase: ForgotUseCase,
) : ViewModel() {

    fun forgotPassword(
        password: String,
    ) = liveData(Dispatchers.IO) {
        try {
            emit(StateView.Loading)
            useCase(password)
            emit(StateView.Success(data = Unit, msg = null))
        } catch (e: Exception) {
            e.message?.let {
                emit(StateView.Error(msg = it))
            }
        }
    }
}