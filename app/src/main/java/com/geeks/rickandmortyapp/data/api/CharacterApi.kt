package com.geeks.rickandmortyapp.data.api

import com.geeks.rickandmortyapp.domain.models.Character
import retrofit2.http.GET

interface CharacterApi {

    @GET("character")
    suspend fun getCharacters(): List<Character>

}