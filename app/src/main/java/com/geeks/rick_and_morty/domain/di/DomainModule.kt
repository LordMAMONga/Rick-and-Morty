package com.geeks.rick_and_morty.domain.di

import com.geeks.rick_and_morty.domain.usecase.GetCharacterByIdUseCase
import com.geeks.rick_and_morty.domain.usecase.GetCharacterTotalInfoUseCase
import com.geeks.rick_and_morty.domain.usecase.GetCharactersByIdsUseCase
import com.geeks.rick_and_morty.domain.usecase.GetCharactersPageSourceUseCase
import com.geeks.rick_and_morty.domain.usecase.GetCharactersUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val domainModule = module{
    factoryOf(::GetCharacterByIdUseCase)
    factoryOf(::GetCharactersByIdsUseCase)
    factoryOf(::GetCharactersUseCase)
    factoryOf(::GetCharactersPageSourceUseCase)
    factoryOf(::GetCharacterTotalInfoUseCase)
}