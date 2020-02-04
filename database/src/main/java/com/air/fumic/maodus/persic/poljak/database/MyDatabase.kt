package com.air.fumic.maodus.persic.poljak.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.air.fumic.maodus.persic.poljak.database.entities.Discount
import com.air.fumic.maodus.persic.poljak.database.entities.Store

@Database(entities = [Store::class, Discount::class], version = 1, exportSchema = false)
abstract class MyDatabase: RoomDatabase() {

    companion object{
        @Volatile private var instance: MyDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also{ instance = it }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(context, MyDatabase::class.java, "localDatabase.db").build()
    }

    abstract fun getDAO(): DAO
}