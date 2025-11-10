package com.geeks.rickandmortyapp.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.geeks.rickandmortyapp.databinding.CharacterItemBinding
import com.geeks.rickandmortyapp.domain.models.Character

class MainScreenAdapter() : RecyclerView.Adapter<MainScreenAdapter.MainScreenViewHolder>() {

    private var data : ArrayList<Character> = arrayListOf()

    fun getList(list: ArrayList<Character>){
        data.clear()
        data.addAll(list)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MainScreenViewHolder {
        return MainScreenViewHolder(
            CharacterItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(
        holder: MainScreenViewHolder,
        position: Int
    ) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

    inner class MainScreenViewHolder(private val binding: CharacterItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(character: Character){
            binding.tvNameCharacter.text = character.name
            binding.tvStatusCharacter.text = character.status
            binding.tvTypeCharacter.text = character.type
            binding.tvGenderCharacter.text = character.gender
            Glide.with(binding.root).load(character.image).into(binding.ivCharacter)
        }
    }
}