package com.geeks.rick_and_morty.data.di

import com.geeks.rick_and_morty.data.repository.RealCharacterRepository
import com.geeks.rick_and_morty.domain.repository.CharacterRepository
import org.koin.dsl.module

val dataModule = module {
    single<CharacterRepository>{ RealCharacterRepository( get()) }
}