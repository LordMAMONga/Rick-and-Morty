package com.geeks.character.domain.usecase

import com.geeks.character.domain.repository.CharacterRepository
import com.geeks.core.network.model.AppError
import com.geeks.core.network.model.DataResult
import com.geeks.character.domain.model.Character


class GetCharacterByIdUseCase(
    private val repository: CharacterRepository
) {
    suspend operator fun invoke(characterId: Int): DataResult<Character, AppError> {
        return repository.getCharacterById(characterId)
    }
}