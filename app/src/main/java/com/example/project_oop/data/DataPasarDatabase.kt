package com.example.project_oop.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.security.AccessControlContext

@Database(entities = [DataPasar::class], version = 1, exportSchema =  false)

abstract class DataPasarDatabase:RoomDatabase() {

    abstract fun dataPasarDao(): DataPasarDao

    companion object{
        @Volatile
        private var INSTACE: DataPasarDatabase? = null

        fun getDatabase(context: Context): DataPasarDatabase {
            val tempInstace = INSTACE
            if (tempInstace != null){
                return tempInstace
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DataPasarDatabase::class.java,
                    "pasar_database"
                ).build()
                INSTACE = instance
                return  instance
            }
        }
    }
}