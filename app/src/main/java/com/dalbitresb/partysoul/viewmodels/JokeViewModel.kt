package com.dalbitresb.partysoul.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.dalbitresb.partysoul.models.Joke
import com.dalbitresb.partysoul.repositories.JokeRepository
import kotlinx.coroutines.launch

class JokeViewModel(private val repository: JokeRepository) : ViewModel() {
    val data: LiveData<List<Joke>> = repository.data.asLiveData()

    fun update(joke: Joke) = viewModelScope.launch {
        repository.update(joke)
    }

    fun insert(joke: Joke) = viewModelScope.launch {
        repository.insert(joke)
    }
}