package com.geeks.episode.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EpisodeResponseDto(
    @SerialName("info")
    val info: InfoDto?,
    @SerialName("results")
    val results: List<EpisodeDto>?
)