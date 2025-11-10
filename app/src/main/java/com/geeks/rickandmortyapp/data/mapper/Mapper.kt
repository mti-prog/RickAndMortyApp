package com.geeks.rickandmortyapp.data.mapper

import com.geeks.rickandmortyapp.data.models.CharacterDto
import com.geeks.rickandmortyapp.domain.models.Character

fun CharacterDto.fromDto(): Character{
    return Character(
        id = id,
        name = name,
        image = image,
        status = status,
        type = type,
        gender = gender
    )
}