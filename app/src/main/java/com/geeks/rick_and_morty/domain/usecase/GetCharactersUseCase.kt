package com.geeks.rick_and_morty.domain.usecase

import com.geeks.rick_and_morty.domain.model.Character
import com.geeks.rick_and_morty.domain.model.CharacterParams
import com.geeks.rick_and_morty.domain.model.CharacterResponse
import com.geeks.rick_and_morty.domain.repository.CharacterRepository
import com.geeks.rick_and_morty.network.model.AppError
import com.geeks.rick_and_morty.network.model.DataResult

class GetCharactersUseCase (
    private val repository: CharacterRepository
) {
    suspend operator fun invoke(params: CharacterParams): DataResult<CharacterResponse, AppError> {
        return repository.getCharacters(params)
    }
}