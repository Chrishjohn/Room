package com.svdroid.mymems.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.svdroid.mymems.model.MemsData
import com.svdroid.mymems.repository.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MemsViewModel(private val mainRepository: MainRepository) : ViewModel() {
    init {
        viewModelScope.launch(Dispatchers.IO) {
            mainRepository.getMems()
        }
    }
    val mems: LiveData<MemsData>
        get() = mainRepository.mems
}