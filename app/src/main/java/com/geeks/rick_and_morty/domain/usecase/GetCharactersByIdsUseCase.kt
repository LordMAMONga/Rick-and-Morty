package com.geeks.rick_and_morty.domain.usecase

import com.geeks.rick_and_morty.domain.model.Character
import com.geeks.rick_and_morty.domain.repository.CharacterRepository
import com.geeks.rick_and_morty.network.model.AppError
import com.geeks.rick_and_morty.network.model.DataResult

class GetCharactersByIdsUseCase(
    private val repository: CharacterRepository
) {
    suspend operator fun invoke(characterIds: List<Int>): DataResult<List<Character>, AppError> {
        return repository.getCharactersByIds(characterIds)
    }
}