package com.geeks.rickandmortyapp.presentation.main

import android.content.ContentProvider
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.util.copy
import com.geeks.rickandmortyapp.core.Either
import com.geeks.rickandmortyapp.domain.model.Character
import com.geeks.rickandmortyapp.domain.usecases.GetCharacterUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

abstract class MainScreenViewModel(
    private val getCharacterUseCase: GetCharacterUseCase
) : ViewModel() {

    private val _characterState = MutableStateFlow<CharacterUIState>(CharacterUIState.Idle)
    val charactersState: StateFlow<CharacterUIState> = _characterState.asStateFlow()

    init {
        getCharacters()
    }

    fun getCharacters() {
        viewModelScope.launch {
            getCharacterUseCase.getCharacter().onStart {
                _characterState.value = CharacterUIState.Loading
            }.collect { result ->
                when (result) {
                    is Either.Left -> {
                        _characterState.value = CharacterUIState.Error(result.value)
                    }

                    is Either.Right -> {
                        _characterState.value = CharacterUIState.Success(result.value)
                    }
                }
            }
        }
    }
}