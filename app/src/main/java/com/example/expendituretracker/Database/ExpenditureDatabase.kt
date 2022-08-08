package com.example.expendituretracker.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Expenditure::class) , version = 1 , exportSchema = false)
abstract class ExpenditureDatabase : RoomDatabase(){

    abstract fun getDao () : ExpenditureDao

    companion object{
        @Volatile
        private var INSTANCE : ExpenditureDatabase? = null

        fun getDatabase (context: Context) : ExpenditureDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ExpenditureDatabase::class.java,
                    "expenditure_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}