package com.geeks.rickandmortyapp.domain.repository

import com.geeks.rickandmortyapp.core.Either
import com.geeks.rickandmortyapp.domain.model.Character
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {

    fun getCharacter(): Flow<Either<String, List<Character>>>

}