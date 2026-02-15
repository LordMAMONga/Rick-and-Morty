package com.geeks.rick_and_morty.ui.di

import com.geeks.rick_and_morty.ui.screens.characters.CharacterListViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val uiModule = module {
    viewModelOf(::CharacterListViewModel)
}