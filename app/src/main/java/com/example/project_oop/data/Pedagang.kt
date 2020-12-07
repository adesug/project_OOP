package com.example.project_oop.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "data_pedagang")
 data class Pedagang (
    @PrimaryKey(autoGenerate = true)
     val id: Int,
     val  nama: String,
     val  alamat_pedagang: String,
     val  no_lapak:Int
 )
