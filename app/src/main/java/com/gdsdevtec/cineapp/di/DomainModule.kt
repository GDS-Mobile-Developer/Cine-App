package com.gdsdevtec.cineapp.di

import com.gdsdevtec.cineapp.data.repository.auth.FirebaseAuthenticationImpl
import com.gdsdevtec.cineapp.domain.repository.auth.FirebaseAuthentication
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DomainModule {

    @Binds
    abstract fun bindsFirebaseAuthenticationImpl(
        bindsFirebaseAuthenticationImpl: FirebaseAuthenticationImpl
    ) : FirebaseAuthentication
}