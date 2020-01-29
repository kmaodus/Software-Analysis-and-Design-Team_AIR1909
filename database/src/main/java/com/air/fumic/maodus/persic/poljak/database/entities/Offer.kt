package com.air.fumic.maodus.persic.poljak.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "offer")
data class Offer (
    @PrimaryKey
    var id: Int,

    @ColumnInfo(name = "amount")
    var amount: Int,

    @ColumnInfo(name = "price")
    var price: Double,

    @ForeignKey(entity = Store::class, parentColumns = ["id"], childColumns = ["id_store"])
    @ColumnInfo(index = true)
    var id_store: Int,

    @ForeignKey(entity = Product::class, parentColumns = ["id"], childColumns = ["id_product"])
    @ColumnInfo(index = true)
    var id_product: Int
)