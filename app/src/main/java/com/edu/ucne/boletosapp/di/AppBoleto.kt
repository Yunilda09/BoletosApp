package com.edu.ucne.boletosapp.di

import com.edu.ucne.boletosapp.data.remote.EventoApi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
        val BaseUrl = "http://192.168.0.107:8090"
    @Singleton
    @Provides
    fun providesMoshi(): Moshi {
        return Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    }

    @Singleton
    @Provides
    fun providesUniqueApi(moshi: Moshi): EventoApi {
        return Retrofit.Builder()
            .baseUrl(BaseUrl)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(EventoApi::class.java)
    }

}