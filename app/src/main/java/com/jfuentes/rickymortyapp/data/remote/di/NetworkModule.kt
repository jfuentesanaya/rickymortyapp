package com.jfuentes.rickymortyapp.data.remote.di

import com.jfuentes.rickymortyapp.BuildConfig
import com.jfuentes.rickymortyapp.data.remote.BASE_URL
import com.jfuentes.rickymortyapp.data.remote.RickyMortyAPI
import com.jfuentes.rickymortyapp.data.remote.RickyMortyServiceImpl
import com.jfuentes.rickymortyapp.domain.RickyMortyService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Juan Fuentes on 28/06/2021.
 */

val networkModule = module {
    single { get<Retrofit>().create(RickyMortyAPI::class.java) }
    single { provideService(get()) }
    single { provideRetrofit() }
}

private fun provideRetrofit() : Retrofit {
    val client = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()

    return Retrofit.Builder()
        .callFactory(client)
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

private fun provideService(rickyMortyAPI: RickyMortyAPI): RickyMortyService {
    return RickyMortyServiceImpl(rickyMortyAPI)
}

private val interceptor = HttpLoggingInterceptor().apply {
    level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
    else HttpLoggingInterceptor.Level.NONE
}