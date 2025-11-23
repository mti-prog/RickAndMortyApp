package com.geeks.rickandmortyapp.domain.usecases

import com.geeks.rickandmortyapp.domain.models.Character
import com.geeks.rickandmortyapp.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow

class GetCharacterUseCase(
    private val characterRepository: CharacterRepository
) {
    fun getCharacter(): Flow<List<Character>> = characterRepository.getCharacter()
}