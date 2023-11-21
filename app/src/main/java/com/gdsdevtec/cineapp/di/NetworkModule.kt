package com.gdsdevtec.cineapp.di

import com.gdsdevtec.cineapp.data.api.ServiceApi
import com.gdsdevtec.cineapp.network.ServiceProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun providerServiceApi(
        serviceProvider: ServiceProvider
    ) = serviceProvider.createService(ServiceApi::class.java)

    @Provides
    fun providersServiceProvider() = ServiceProvider()
}