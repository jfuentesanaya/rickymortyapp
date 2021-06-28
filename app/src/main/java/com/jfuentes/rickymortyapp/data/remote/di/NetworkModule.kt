package com.jfuentes.rickymortyapp.data.remote.di

import com.jfuentes.rickymortyapp.data.remote.RickyMortyAPI
import com.jfuentes.rickymortyapp.data.remote.RickyMortyServiceImpl
import com.jfuentes.rickymortyapp.domain.RickyMortyService
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Juan Fuentes on 28/06/2021.
 */

val networkModule = module {

    single { provideRetrofit(get()) }
    single { provideService(get()) }
}


private fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder().baseUrl("https://rickandmortyapi.com/api").client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create()).build()
}

private fun provideService(rickyMortyAPI: RickyMortyAPI): RickyMortyService {
    return RickyMortyServiceImpl(rickyMortyAPI)
}