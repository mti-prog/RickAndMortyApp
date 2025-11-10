package com.geeks.rickandmortyapp.domain.usecases

import com.geeks.rickandmortyapp.domain.models.Character
import com.geeks.rickandmortyapp.domain.repository.CharacterRepository

class GetCharacterUseCase(
    private val characterRepository: CharacterRepository
) {
    fun getCharacter(): Character{
        return characterRepository.getCharacter()
    }
}