package com.geeks.rick_and_morty.domain.usecase

import com.geeks.rick_and_morty.domain.model.Character
import com.geeks.rick_and_morty.domain.repository.CharacterRepository
import com.geeks.rick_and_morty.network.model.AppError
import com.geeks.rick_and_morty.network.model.DataResult

class GetCharacterByIdUseCase (
    private val repository: CharacterRepository
) {
    suspend operator fun invoke(characterId: Int): DataResult<Character, AppError> {
        return repository.getCharacterById(characterId)
    }
}