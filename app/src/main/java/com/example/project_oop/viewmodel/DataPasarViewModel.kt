package com.example.project_oop.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.project_oop.data.DataPasarDatabase
import com.example.project_oop.model.DataPasar
import com.example.project_oop.repository.DataPasarRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class DataPasarViewModel(application: Application): AndroidViewModel(application) {
    val readAllData: LiveData<List<DataPasar>>
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

    fun updatePasar(dataPasar: DataPasar){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updatePasar(dataPasar)
        }
    }

    fun deletePasar(dataPasar: DataPasar){
        viewModelScope.launch(Dispatchers.IO){
            repository.deletePasar(dataPasar)
        }
    }

    fun deleteAllPasars(){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteAllPasars()
        }
    }
}