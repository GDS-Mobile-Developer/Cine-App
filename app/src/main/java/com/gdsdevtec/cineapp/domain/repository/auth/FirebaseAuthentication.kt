package com.gdsdevtec.cineapp.domain.repository.auth

interface FirebaseAuthentication {
    suspend fun register(email : String,password: String)
    suspend fun login(email : String,password: String)
    suspend fun forgot(email : String)
}