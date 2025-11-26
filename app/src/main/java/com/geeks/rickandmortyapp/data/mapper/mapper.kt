package com.geeks.rickandmortyapp.data.mapper

import com.geeks.rickandmortyapp.data.models.CharacterDto
import com.geeks.rickandmortyapp.data.models.LocationDto
import com.geeks.rickandmortyapp.data.models.OriginDto
import com.geeks.rickandmortyapp.domain.model.Character
import com.geeks.rickandmortyapp.domain.model.Location
import com.geeks.rickandmortyapp.domain.model.Origin

fun CharacterDto?.toDomain(): Character {
    return Character(
        created = this?.created ?: "",
        episode = this?.episode?: emptyList(),
        gender = this?.gender ?: "",
        id = this?.id ?: 0,
        image = this?.image ?: "",
        location = this?.location.toDomain(),
        name = this?.name ?: "",
        origin = this?.origin.toDomain(),
        species = this?.species ?: "",
        status = this?.status ?: "",
        type = this?.type ?: "",
        url = this?.url ?: ""
    )
}

fun LocationDto?.toDomain(): Location {
    return Location(
        name = this?.name ?: "",
        url = this?.url ?: ""
    )
}

fun OriginDto?.toDomain(): Origin {
    return Origin(
        name = this?.name ?: "",
        url = this?.url ?: ""
    )
}

fun List<CharacterDto>?.toDomain(): List<Character> {
    return this?.map { characterDto ->
        characterDto.toDomain()
    } ?: emptyList()
}
