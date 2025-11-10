package com.geeks.rickandmortyapp.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.geeks.rickandmortyapp.domain.usecases.GetCharacterUseCase

class MainScreenViewModel(
private val getCharacterUseCase: GetCharacterUseCase
) : ViewModel() {

    private val _characterData = MutableLiveData<Character>()
    val characterData: LiveData<Character> = _characterData

//    private fun getCharacters(){
//        val response = getCharacterUseCase.getCharacter()
//        _characterData.value = response
//    }
}