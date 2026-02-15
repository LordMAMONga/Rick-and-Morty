package com.geeks.rick_and_morty.ui.screens.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.geeks.rick_and_morty.domain.model.CharacterParams
import com.geeks.rick_and_morty.domain.usecase.GetCharactersPageSourceUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn

class CharacterListViewModel(
    private val getCharactersPageSourceUseCase: GetCharactersPageSourceUseCase
) : ViewModel() {

//    val scope = CoroutineScope(Dispatchers.Main + SupervisorJob())   // Вот не забыл как вы и говорили :)

    val pagingData =
        getCharactersPageSourceUseCase(CharacterParams(page = 1)).cachedIn(viewModelScope)
            .stateIn(
                viewModelScope,
                started = SharingStarted.Lazily,
                initialValue = PagingData.empty()
            )
}