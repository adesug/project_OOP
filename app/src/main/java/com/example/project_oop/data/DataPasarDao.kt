package com.example.project_oop.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.project_oop.model.DataPasar

@Dao
interface DataPasarDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addDataPasar(dataPasar: DataPasar)

    @Update
    suspend fun updatePasar(dataPasar: DataPasar)

    @Delete
    suspend fun deletePasar(dataPasar: DataPasar)

    @Query("DELETE FROM tb_pasar")
    suspend fun deleteAllPasars()

    @Query("SELECT * FROM tb_pasar ORDER BY id ASC")
    fun readAllData(): LiveData<List<DataPasar>>
}