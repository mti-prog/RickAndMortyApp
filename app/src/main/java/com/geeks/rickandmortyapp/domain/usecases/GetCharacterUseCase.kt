package com.geeks.rickandmortyapp.domain.usecases

import com.geeks.rickandmortyapp.core.Either
import com.geeks.rickandmortyapp.domain.model.Character
import com.geeks.rickandmortyapp.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow

class GetCharacterUseCase(
    private val characterRepository: CharacterRepository
) {
    fun getCharacter(): Flow<Either<String, List<Character>>> = characterRepository.getCharacter()
}