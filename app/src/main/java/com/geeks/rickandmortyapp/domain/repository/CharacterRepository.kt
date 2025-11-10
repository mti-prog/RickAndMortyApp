package com.geeks.rickandmortyapp.domain.repository

import com.geeks.rickandmortyapp.domain.models.Character

interface CharacterRepository {
    fun getCharacter(): Character
}