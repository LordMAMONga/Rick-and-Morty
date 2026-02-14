package com.geeks.rick_and_morty.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.geeks.rick_and_morty.data.datasource.CharacterPageSource
import com.geeks.rick_and_morty.data.mapper.toDomain
import com.geeks.rick_and_morty.data.model.CharacterDto
import com.geeks.rick_and_morty.data.model.CharacterResponseDto
import com.geeks.rick_and_morty.domain.model.Character
import com.geeks.rick_and_morty.domain.model.CharacterParams
import com.geeks.rick_and_morty.domain.model.CharacterResponse
import com.geeks.rick_and_morty.domain.model.Info
import com.geeks.rick_and_morty.domain.repository.CharacterRepository
import com.geeks.rick_and_morty.network.model.AppError
import com.geeks.rick_and_morty.network.model.DataResult
import com.geeks.rick_and_morty.network.model.map
import com.geeks.rick_and_morty.network.util.safeGet
import io.ktor.client.HttpClient
import io.ktor.utils.io.ioDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class RealCharacterRepository(
    private val client: HttpClient
) : CharacterRepository {

    override fun getCharactersPageSource(params: CharacterParams): Flow<PagingData<Character>> =
        Pager(
            config = PagingConfig(pageSize = 20, prefetchDistance = 20, enablePlaceholders = false),
            pagingSourceFactory = {
                CharacterPageSource(requestParams = params) { params ->
                    getCharacters(params)
                }
            }
        ).flow.flowOn(Dispatchers.IO)

    override suspend fun getCharacters(params: CharacterParams): DataResult<CharacterResponse, AppError> =
        client.safeGet<CharacterResponseDto>(url = "character", dispatcher = Dispatchers.IO) {
            url.parameters.apply {
                append("page", params.page.toString())
                params.query?.let { append("query", it) }
                params.status?.let { append("status", it) }
                params.gender?.let { append("gender", it) }
                params.species?.let { append("species", it) }
                params.type?.let { append("type", it) }
            }
        }.map {
            it.toDomain()
        }


    override suspend fun getCharacterById(characterId: Int): DataResult<Character, AppError> =
        client.safeGet<CharacterDto>(url = "character/${characterId}", dispatcher = Dispatchers.IO)
            .map { it.toDomain() }


    override suspend fun getCharactersByIds(characterIds: List<Int>): DataResult<List<Character>, AppError> =
        client.safeGet<List<CharacterDto>>(
            url = "character/${
                characterIds.joinToString(separator = ",", prefix = "[", postfix = "]")
            }", dispatcher = ioDispatcher()
        ).map { result -> result.map { it.toDomain() } }

    override suspend fun getCharacterTotalInfo(): DataResult<Info, AppError> =
        client.safeGet<CharacterResponseDto>(url = "character?page=1", dispatcher = Dispatchers.IO)
            .map { it.info?.toDomain() ?: throw Exception("информации о персонажах нету") }
}