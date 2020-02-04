package com.air.fumic.maodus.persic.poljak.database

import androidx.room.*
import com.air.fumic.maodus.persic.poljak.database.entities.*

@Dao
interface  DAO {

    @Query("SELECT * FROM store")
    fun getStores(): List<Store>

    @Query("SELECT * FROM discount")
    fun getDiscounts(): List<Discount>

    @Insert
    fun insertStore(vararg new_store: Store)

    @Insert
    fun insertDiscount(vararg new_discount: Discount)

    @Delete
    fun deleteStore(store: Store)

    @Delete
    fun deleteDiscount(discount: Discount)

    @Update
    fun updateStore(vararg store: Store)

    @Update
    fun updateDiscount(vararg discount: Discount)
}