package com.geeks.rick_and_morty.domain.usecase

import com.geeks.rick_and_morty.domain.model.Info
import com.geeks.rick_and_morty.domain.repository.CharacterRepository
import com.geeks.rick_and_morty.network.model.AppError
import com.geeks.rick_and_morty.network.model.DataResult


class GetCharacterTotalInfoUseCase(
    private val repository: CharacterRepository
) {
    suspend operator fun invoke(): DataResult<Info, AppError> {
        return repository.getCharacterTotalInfo()
    }
}