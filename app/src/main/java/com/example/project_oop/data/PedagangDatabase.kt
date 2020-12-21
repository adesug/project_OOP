package com.example.project_oop.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import  androidx.room.RoomDatabase
import com.example.project_oop.model.Pedagang

@Database(entities = [Pedagang::class], version = 1, exportSchema = false)

abstract  class  PedagangDatabase: RoomDatabase(){

    abstract  fun pedagangDao(): PedagangDao

    companion object{
        @Volatile
        private var  INSTANCE: PedagangDatabase? = null

        fun getDatabase(context: Context): PedagangDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PedagangDatabase::class.java,
                    "pedagang_database")

                .build()
                INSTANCE = instance
                return instance
            }
        }
    }

}
