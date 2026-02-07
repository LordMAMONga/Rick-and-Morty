package com.geeks.rick_and_morty.data.mapper

import com.geeks.rick_and_morty.data.model.CharacterDto
import com.geeks.rick_and_morty.data.model.CharacterLocationDto
import com.geeks.rick_and_morty.data.model.CharacterResponseDto
import com.geeks.rick_and_morty.data.model.InfoDto
import com.geeks.rick_and_morty.data.model.OriginDto
import com.geeks.rick_and_morty.domain.model.CharacterLocation
import com.geeks.rick_and_morty.domain.model.CharacterResponse
import com.geeks.rick_and_morty.domain.model.Info
import com.geeks.rick_and_morty.domain.model.Origin
import  com.geeks.rick_and_morty.domain.model.Character

fun CharacterResponseDto.toDomain(): CharacterResponse {
    return CharacterResponse(
        info = this.info?.toDomain() ?: Info(count = -1, pages = -1, next = "", prev = ""),
        results = this.results?.map { it.toDomain() } ?: emptyList()
    )
}

fun CharacterDto.toDomain(): Character {
    return Character(
        id = this.id ?: 0,
        name = this.name.orEmpty(),
        status = this.status.orEmpty(),
        species = this.species.orEmpty(),
        type = this.type.orEmpty(),
        gender = this.gender.orEmpty(),
        origin = this.origin?.toDomain() ?: Origin(name = "", url = ""),
        characterLocation = this.characterLocation?.toDomain() ?: CharacterLocation(
            name = "",
            url = ""
        ),
        image = this.image.orEmpty(),
        episode = this.episode.orEmpty(),
        url = this.url.orEmpty(),
        created = this.created.orEmpty()
    )
}

fun OriginDto.toDomain(): Origin {
    return Origin(
        name = this.name.orEmpty(),
        url = this.url.orEmpty()
    )
}

fun CharacterLocationDto.toDomain(): CharacterLocation {
    return CharacterLocation(
        name = name.orEmpty(),
        url = url.orEmpty()
    )
}


fun InfoDto.toDomain(): Info {
    return Info(
        count = this.count ?: 0,
        pages = this.pages ?: 0,
        next = this.next ?: "",
        prev = this.prev ?: ""
    )
}