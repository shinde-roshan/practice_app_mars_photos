package com.example.marsphotos.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marsphotos.network.MarsApi
import com.example.marsphotos.network.MarsPhoto
import kotlinx.coroutines.launch

class OverviewViewModel : ViewModel() {
    private val _status = MutableLiveData<String>()
    private var _photos = MutableLiveData<MarsPhoto>()
    val status: LiveData<String> = _status
    val photos: LiveData<MarsPhoto> = _photos

    init {
        getMarsPhotos()
    }

    private fun getMarsPhotos() {
        try {
            viewModelScope.launch {
                val response = MarsApi.retrofitService.getPhotos()
                _photos.value = response[0]
                _status.value = "Success: ${response.size} mars photos received."
            }
        } catch (e: Exception) {
            _status.value = e.message
        }
    }
}