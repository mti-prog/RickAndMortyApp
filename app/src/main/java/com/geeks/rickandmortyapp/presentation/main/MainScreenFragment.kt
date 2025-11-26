package com.geeks.rickandmortyapp.presentation.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.geeks.rickandmortyapp.databinding.FragmentMainScreenBinding
import com.geeks.rickandmortyapp.domain.model.Character
import com.geeks.rickandmortyapp.presentation.adapter.MainScreenAdapter
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainScreenFragment : Fragment() {
    private val adapter = MainScreenAdapter()
    private lateinit var binding : FragmentMainScreenBinding
    private val viewModel: MainScreenViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        viewLifeCycleUI()
    }

    private fun viewLifeCycleUI() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.charactersState.collect {
                    handleUIState(it)
                }
            }
        }
    }
    private fun handleUIState(uiState: CharacterUIState) {
        // Скрываем индикатор загрузки по умолчанию
        binding.progressBar.visibility = View.GONE
        when (uiState) {
            is CharacterUIState.Loading -> {
                binding.progressBar.visibility = View.VISIBLE
            }
            is CharacterUIState.Success -> {
                loadData(uiState.characters)
            }
            is CharacterUIState.Error -> {
                Toast.makeText(requireContext(), "Error: ${uiState.message}", Toast.LENGTH_LONG).show()
            }

            CharacterUIState.Idle -> ""
        }
    }

    private fun loadData(characters: List<Character>) {
        adapter.getList(characters)
    }

    private fun init(){
        binding.rvCharacters.adapter = adapter
    }

}