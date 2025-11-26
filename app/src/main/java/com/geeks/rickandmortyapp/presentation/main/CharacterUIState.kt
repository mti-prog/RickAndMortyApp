package com.geeks.rickandmortyapp.presentation.main

import com.geeks.rickandmortyapp.domain.model.Character

sealed class CharacterUIState {
    object Loading : CharacterUIState()
    data class Success(val characters: List<Character>) : CharacterUIState()
    data class Error(val message: String) : CharacterUIState()
    object Idle : CharacterUIState()
}