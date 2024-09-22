package com.example.mygames2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mygames2.data.model.Game
import com.example.mygames2.data.network.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _gamesResponse = MutableStateFlow<List<Game>>(emptyList())
    val gamesResponse: StateFlow<List<Game>> get() = _gamesResponse

    fun getAllGames() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.apiService.getGames(platform = "pc")
                if (response.isSuccessful) {
                    _gamesResponse.value = response.body() ?: emptyList()
                }
            } catch (e: Exception) {
                println(e)
            }
        }
    }
}