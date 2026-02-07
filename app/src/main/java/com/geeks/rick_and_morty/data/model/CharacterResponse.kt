package com.geeks.rick_and_morty.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharacterResponseDto(
    @SerialName("info") val info: InfoDto? = null,
    @SerialName("results") val results: List<CharacterDto>? = null
)