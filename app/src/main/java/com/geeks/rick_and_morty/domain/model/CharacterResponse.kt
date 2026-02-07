package com.geeks.rick_and_morty.domain.model

data class CharacterResponse(
    val info: Info,
    val results: List<Character>
)
