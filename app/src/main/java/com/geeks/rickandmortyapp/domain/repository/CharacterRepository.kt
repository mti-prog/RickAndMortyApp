package com.geeks.rickandmortyapp.domain.repository

import com.geeks.rickandmortyapp.domain.models.Character
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {

    fun getCharacter(): Flow<List<Character>>

}