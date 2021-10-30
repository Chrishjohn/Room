package com.svdroid.mymems.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.svdroid.mymems.repository.MainRepository

class MemsViewModelFactory(private val mainRepository: MainRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MemsViewModel(mainRepository) as T
    }
}