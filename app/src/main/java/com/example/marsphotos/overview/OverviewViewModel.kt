package com.example.marsphotos.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marsphotos.network.MarsApi
import kotlinx.coroutines.launch

class OverviewViewModel : ViewModel() {
    private val _status = MutableLiveData<String>()
    val status: LiveData<String> = _status

    init {
        getMarsPhotos()
    }

    private fun getMarsPhotos() {
        try {
            viewModelScope.launch {
                val response = MarsApi.retrofitService.getPhotos()
                _status.value = response
            }
        } catch (e: Exception) {
            _status.value = e.message
        }
    }
}