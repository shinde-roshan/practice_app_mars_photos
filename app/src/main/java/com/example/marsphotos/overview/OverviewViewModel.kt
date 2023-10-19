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
    private var _photos = MutableLiveData<List<MarsPhoto>>()
    val status: LiveData<String> = _status
    val photos: LiveData<List<MarsPhoto>> = _photos

    init {
        getMarsPhotos()
    }

    private fun getMarsPhotos() {
        try {
            viewModelScope.launch {
                _photos.value = MarsApi.retrofitService.getPhotos()
                _status.value = "Success: ${_photos.value!!.size} mars photos received."
            }
        } catch (e: Exception) {
            _status.value = e.message
        }
    }
}