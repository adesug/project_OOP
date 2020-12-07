package com.example.project_oop.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class DataPasarViewModel(application: Application): AndroidViewModel(application) {
    private val readAllData: LiveData<List<DataPasar>>
    private val repository: DataPasarRepository

    init {
        val dataPasarDao = DataPasarDatabase.getDatabase(application).dataPasarDao()
        repository = DataPasarRepository(dataPasarDao)
        readAllData = repository.readAllData
    }

    fun  addData(dataPasar: DataPasar){
        viewModelScope.launch(Dispatchers.IO){
            repository.addDataPasar(dataPasar)
        }
    }
}