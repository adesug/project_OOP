package com.example.project_oop.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class PedagangViewModel(aplication:Application): AndroidViewModel(aplication){
    private val readAllData: LiveData<List<Pedagang>>
    private val repository: PedagangRepository

    init {
        val pedagangDao = PedagangDatabase.getDatabase(aplication).pedagangDao()
        repository = PedagangRepository(pedagangDao)
        readAllData =repository.readAllData
    }

    fun addPedagang(pedagang: Pedagang){
        viewModelScope.launch (Dispatchers.IO){
            repository.addPedagang(pedagang)
        }
    }

}