package com.jfuentes.rickymortyapp.domain.di

import com.jfuentes.rickymortyapp.domain.usecase.GetCharacterListUseCase
import com.jfuentes.rickymortyapp.domain.usecase.GetDetailCharacterUseCase
import com.jfuentes.rickymortyapp.domain.RickyMortyService
import org.koin.dsl.module

/**
 * Created by Juan Fuentes on 29/06/2021.
 */

val useCaseModule = module {
    single { provideCharactersUseCase(get()) }
    single { provideCharacterDetailUseCase(get()) }
}

fun provideCharacterDetailUseCase(service: RickyMortyService) = GetCharacterListUseCase(service)

fun provideCharactersUseCase(service: RickyMortyService) = GetDetailCharacterUseCase(service)
