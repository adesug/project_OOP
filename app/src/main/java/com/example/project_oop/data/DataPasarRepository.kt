package com.example.project_oop.data

import androidx.lifecycle.LiveData

class DataPasarRepository(private val dataPasarDao: DataPasarDao) {
    val readAllData: LiveData<List<DataPasar>> = dataPasarDao.readAllData()

    suspend fun addDataPasar(dataPasar: DataPasar){
        dataPasarDao.addDataPasar(dataPasar)
    }
}