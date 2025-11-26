package com.geeks.rickandmortyapp.data.api

import com.geeks.rickandmortyapp.data.models.BaseResponseDto
import retrofit2.Response
import retrofit2.http.GET

interface CharacterApi {

    @GET("character")
    suspend fun getCharacters(): Response<BaseResponseDto>

}