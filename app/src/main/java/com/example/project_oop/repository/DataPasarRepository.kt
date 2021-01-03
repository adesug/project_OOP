package com.example.project_oop.repository

import androidx.lifecycle.LiveData
import com.example.project_oop.data.DataPasarDao
import com.example.project_oop.model.DataPasar

class DataPasarRepository(private val dataPasarDao: DataPasarDao) {
    val readAllData: LiveData<List<DataPasar>> = dataPasarDao.readAllData()

    suspend fun addDataPasar(dataPasar: DataPasar){
        dataPasarDao.addDataPasar(dataPasar)
    }

    suspend fun updatePasar(dataPasar: DataPasar){
        dataPasarDao.updatePasar(dataPasar)
    }

    suspend fun deletePasar(dataPasar: DataPasar){
        dataPasarDao.deletePasar(dataPasar)
    }

    suspend fun deleteAllPasars(){
        dataPasarDao.deleteAllPasars()
    }
}