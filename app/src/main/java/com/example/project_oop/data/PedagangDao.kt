package com.example.project_oop.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.project_oop.model.Pedagang

@Dao
interface PedagangDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun  addPedagang(pedagang: Pedagang)

    @Update
    suspend fun updatePedagang(pedagang: Pedagang)

    @Delete
    suspend fun deletePedagang(pedagang: Pedagang)

    @Query( "DELETE FROM data_pedagang")
    suspend fun deleteAllPedagang()

    @Query (value = "SELECT * FROM data_pedagang ORDER BY id ASC")
    fun readAllData(): LiveData<List<Pedagang>>
}