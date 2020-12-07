package com.example.project_oop.data

import androidx.lifecycle.LiveData

class PedagangRepository (private val pedagangDao: PedagangDao){

    val readAllData: LiveData<List<Pedagang>> = pedagangDao.readAllData()

    suspend fun  addPedagang (pedagang: Pedagang){
        pedagangDao.addPedagang(pedagang)
    }
}