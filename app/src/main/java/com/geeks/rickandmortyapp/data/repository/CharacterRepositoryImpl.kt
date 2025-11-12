package com.geeks.rickandmortyapp.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.geeks.rickandmortyapp.data.api.CharacterApi
import com.geeks.rickandmortyapp.domain.models.Character
import com.geeks.rickandmortyapp.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CharacterRepositoryImpl(
    private val api: CharacterApi
) : CharacterRepository {

    override fun getCharacter(): Flow<List<Character>> {
        return flow {
            try {
                val response = api.getCharacters()
                emit(response)
            } catch (e: Exception) {

            }
        }
    }


}