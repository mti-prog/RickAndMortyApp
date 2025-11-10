package com.geeks.rickandmortyapp.di

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val cartoonModule = module {
    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single<OkHttpClient> {
        OkHttpClient.Builder()
            .addInterceptor(interceptor = get())
            .build()
    }

    single<HttpLoggingInterceptor>{
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }
}