package com.geeks.rickandmortyapp.presentation.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.geeks.rickandmortyapp.databinding.FragmentMainScreenBinding
import com.geeks.rickandmortyapp.domain.models.Character
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
                    loadData(it)
                }
            }
        }
    }

    private fun loadData(characters: List<Character>) {

    }

    private fun init(){
        binding.rvCharacters.adapter = adapter
    }

}