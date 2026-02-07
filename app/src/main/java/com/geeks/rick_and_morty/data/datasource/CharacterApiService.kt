package com.geeks.rick_and_morty.data.datasource

import com.geeks.rick_and_morty.data.mapper.toDomain
import com.geeks.rick_and_morty.data.model.CharacterRequest
import com.geeks.rick_and_morty.data.model.CharacterResponseDto
import com.geeks.rick_and_morty.domain.model.CharacterResponse
import com.geeks.rick_and_morty.network.model.AppError
import com.geeks.rick_and_morty.network.model.DataResult
import com.geeks.rick_and_morty.network.model.map
import com.geeks.rick_and_morty.network.util.safeGet
import io.ktor.client.HttpClient
import io.ktor.client.request.parameter
import kotlinx.coroutines.Dispatchers

class CharacterApiService(
    private val client: HttpClient
) {

    suspend fun getCharacters(request: CharacterRequest): DataResult<CharacterResponse, AppError> =
        client.safeGet<CharacterResponseDto>(url = "character", dispatcher = Dispatchers.IO) {
            url.parameters.apply {
                append("page",request.page.toString())
                request.query?.let { append("query",it) }
                request.status?.let { append("status",it) }
                request.gender?.let { append("gender",it) }
                request.species?.let { append("species",it) }
                request.type?.let { append("type",it) }
            }
        }.map {
            it.toDomain()
        }
}