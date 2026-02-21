package com.geeks.character.domain.repository

import androidx.paging.PagingData
import com.geeks.character.domain.model.CharacterParams
import com.geeks.character.domain.model.Character
import com.geeks.character.domain.model.CharacterResponse
import com.geeks.character.domain.model.Info
import com.geeks.core.network.model.AppError
import com.geeks.core.network.model.DataResult
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {

    fun getCharactersPageSource(params: CharacterParams): Flow<PagingData<Character>>

    suspend fun getCharacters(params: CharacterParams): DataResult<CharacterResponse, AppError>

    suspend fun getCharacterById(characterId: Int): DataResult<Character, AppError>

    suspend fun getCharactersByIds(characterIds: List<Int>): DataResult<List<Character>, AppError>

    suspend fun getCharactersTotalInfo(): DataResult<Info, AppError>
}