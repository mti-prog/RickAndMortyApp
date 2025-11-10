package com.geeks.rickandmortyapp.data.repository

import com.geeks.rickandmortyapp.data.api.CharacterApi
import com.geeks.rickandmortyapp.domain.models.Character
import com.geeks.rickandmortyapp.domain.repository.CharacterRepository

class CharacterRepositoryImpl(
private val api : CharacterApi
): CharacterRepository {
    override fun getCharacter(): Character {
        TODO("Not yet implemented")
    }
}