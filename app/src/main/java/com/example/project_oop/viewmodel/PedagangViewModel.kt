package com.example.project_oop.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.project_oop.data.PedagangDatabase
import com.example.project_oop.repository.PedagangRepository
import com.example.project_oop.model.Pedagang
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class PedagangViewModel(aplication:Application): AndroidViewModel(aplication){
    val readAllData: LiveData<List<Pedagang>>
    private val repository: PedagangRepository

    init {
        val pedagangDao = PedagangDatabase.getDatabase(
            aplication
        ).pedagangDao()
        repository =
            PedagangRepository(pedagangDao)
        readAllData =repository.readAllData
    }

    fun addPedagang(pedagang: Pedagang){
        viewModelScope.launch (Dispatchers.IO){
            repository.addPedagang(pedagang)
        }
    }

    fun updatePedagang(pedagang: Pedagang){
        viewModelScope.launch(Dispatchers.IO){
           repository.updatePedagang(pedagang)
        }
    }
    fun deletePedagang( pedagang: Pedagang){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deletePedagang(pedagang)
        }
    }

    fun deleteAllPedagang(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllPedagang()
        }
    }

}