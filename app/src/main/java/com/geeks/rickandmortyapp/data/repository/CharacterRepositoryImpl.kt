package com.geeks.rickandmortyapp.data.repository

import com.geeks.rickandmortyapp.core.Either
import com.geeks.rickandmortyapp.data.api.CharacterApi
import com.geeks.rickandmortyapp.data.mapper.toDomain
import com.geeks.rickandmortyapp.domain.model.Character
import com.geeks.rickandmortyapp.domain.repository.CharacterRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class CharacterRepositoryImpl(
    private val api: CharacterApi
) : CharacterRepository {

    override fun getCharacter(): Flow<Either<String, List<Character>>> {
        return flow {
            try {
                val response = api.getCharacters()
                if (response.isSuccessful && response.body() != null) {
                    response.body()?.let { result ->
                        emit(Either.Right(result.results.toDomain()))
                    }
                }else{
                    emit(Either.Left(response.message()))
                }
            } catch (e: Exception) {
                emit(Either.Left(e.localizedMessage ?: "Unknown error"))
            }
        }.flowOn(Dispatchers.IO)
    }
}