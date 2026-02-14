package com.geeks.rick_and_morty.domain.repository

import androidx.paging.PagingData
import com.geeks.rick_and_morty.domain.model.Character
import com.geeks.rick_and_morty.domain.model.CharacterParams
import com.geeks.rick_and_morty.domain.model.CharacterResponse
import com.geeks.rick_and_morty.domain.model.Info
import com.geeks.rick_and_morty.network.model.AppError
import com.geeks.rick_and_morty.network.model.DataResult
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {

    fun getCharactersPageSource(params: CharacterParams): Flow<PagingData<Character>>

    suspend fun getCharacters(params: CharacterParams): DataResult<CharacterResponse, AppError>

    suspend fun getCharacterById(characterId: Int): DataResult<Character, AppError>

    suspend fun getCharactersByIds(characterIds: List<Int>): DataResult<List<Character>, AppError>

    suspend fun getCharacterTotalInfo(): DataResult<Info, AppError>
}