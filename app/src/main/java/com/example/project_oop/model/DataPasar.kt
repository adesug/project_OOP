package com.example.project_oop.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "tb_pasar")
data class DataPasar (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val namaPasar: String,
    val alamatPasar: String,
    val tipePasar: String
): Parcelable