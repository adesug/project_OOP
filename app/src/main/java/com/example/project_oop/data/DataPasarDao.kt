package com.example.project_oop.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DataPasarDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addDataPasar(dataPasar: DataPasar)

    @Query("SELECT * FROM tb_pasar ORDER BY id ASC")
    fun readAllData(): LiveData<List<DataPasar>>
}