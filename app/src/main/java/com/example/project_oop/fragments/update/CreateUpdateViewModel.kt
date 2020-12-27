package com.example.project_oop.fragments.update

import androidx.lifecycle.ViewModel
import com.example.project_oop.data.PedagangDatabase
import com.example.project_oop.model.Pedagang

class CreateUpdateViewModel (private val pedagangDatabase: PedagangDatabase):ViewModel(){
    fun update(id:Int, nama:String, alamat_pedagang:String, no_lapak:Int) = pedagangDatabase.pedagangDao().insert(
        Pedagang(id=id, nama=nama, alamat_pedagang = alamat_pedagang, no_lapak = no_lapak))
    fun findById(id: Int) = pedagangDatabase.pedagangDao().findById(id)
}