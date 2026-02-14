package com.geeks.rick_and_morty.domain.usecase

import androidx.paging.PagingData
import com.geeks.rick_and_morty.domain.model.Character
import com.geeks.rick_and_morty.domain.model.CharacterParams
import com.geeks.rick_and_morty.domain.repository.CharacterRepository
import com.geeks.rick_and_morty.network.model.AppError
import com.geeks.rick_and_morty.network.model.DataResult
import kotlinx.coroutines.flow.Flow

class GetCharactersPageSourceUseCase(
    private val repository: CharacterRepository
) {
    operator fun invoke(params: CharacterParams): Flow<PagingData<Character>> {
        return repository.getCharactersPageSource(params)
    }
}