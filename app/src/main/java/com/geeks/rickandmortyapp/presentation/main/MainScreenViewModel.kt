package com.geeks.rickandmortyapp.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.geeks.rickandmortyapp.domain.models.Character
import com.geeks.rickandmortyapp.domain.usecases.GetCharacterUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainScreenViewModel(
private val getCharacterUseCase: GetCharacterUseCase
) : ViewModel() {

    private val _characterState = MutableStateFlow<List<Character>>(emptyList())
    val charactersState: StateFlow<List<Character>> = _characterState.asStateFlow()

    fun getCharacters(){
        viewModelScope.launch {
            getCharacterUseCase.getCharacter().collect { it->
                _characterState.value = it
            }
        }
    }
}