package com.example.project_oop.repository

import androidx.lifecycle.LiveData
import com.example.project_oop.data.PedagangDao
import com.example.project_oop.model.Pedagang

class PedagangRepository (private val pedagangDao: PedagangDao){

    val readAllData: LiveData<List<Pedagang>> = pedagangDao.readAllData()

    suspend fun  addPedagang (pedagang: Pedagang){
        pedagangDao.addPedagang(pedagang)
    }

    suspend fun  updatePedagang(pedagang: Pedagang){
        pedagangDao.updatePedagang(pedagang)
    }
    suspend fun deletePedagang(pedagang: Pedagang){
        pedagangDao.deletePedagang(pedagang)
    }
    suspend fun deleteAllPedagang(){
        pedagangDao.deleteAllPedagang()
    }
}