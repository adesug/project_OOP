package com.example.project_oop.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import  androidx.room.Insert
import  androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PedagangDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun  addPedagang(pedagang: Pedagang)

    @Query (value = "SELECT * FROM data_pedagang ORDER BY id ASC")
    fun readAllData(): LiveData<List<Pedagang>>
}