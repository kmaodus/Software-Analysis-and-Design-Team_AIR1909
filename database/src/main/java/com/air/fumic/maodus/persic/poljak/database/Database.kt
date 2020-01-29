package com.air.fumic.maodus.persic.poljak.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.air.fumic.maodus.persic.poljak.database.entities.Discount
import com.air.fumic.maodus.persic.poljak.database.entities.Store

@Database(entities = [Store::class, Discount::class], version = 1, exportSchema = false)
abstract class Database: RoomDatabase() {

    abstract fun DAO(): DAO
}