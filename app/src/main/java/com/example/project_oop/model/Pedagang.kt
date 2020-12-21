package com.example.project_oop.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "data_pedagang")
 data class Pedagang (
    @PrimaryKey(autoGenerate = true)
     val id: Int,
     val  nama: String,
     val  alamat_pedagang: String,
     val  no_lapak:Int
 ): Parcelable
