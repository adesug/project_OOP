package com.example.project_oop.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_pasar")
data class DataPasar (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val namaPasar: String,
    val alamatPasar: String,
    val tipePasar: String
)