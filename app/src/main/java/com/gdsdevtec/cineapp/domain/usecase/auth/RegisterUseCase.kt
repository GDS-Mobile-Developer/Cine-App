package com.gdsdevtec.cineapp.domain.usecase.auth

import com.gdsdevtec.cineapp.domain.repository.auth.FirebaseAuthentication

class RegisterUseCase constructor(
    private val firebaseAuthentication: FirebaseAuthentication
) {

    suspend operator fun invoke(email: String,password : String){
        firebaseAuthentication.register(email, password)
    }
}