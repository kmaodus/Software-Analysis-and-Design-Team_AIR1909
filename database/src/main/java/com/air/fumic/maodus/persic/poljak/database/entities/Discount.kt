package com.air.fumic.maodus.persic.poljak.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "discount")
data class Discount (
    @PrimaryKey var id: Int,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "start_date") var start_date: String,
    @ColumnInfo(name = "end_date") var end_date: String,
    @ColumnInfo(name = "discount") var discount: Int,

    @ForeignKey(entity = Store::class, parentColumns = ["id"], childColumns = ["id_store"])
    @ColumnInfo(index = true)
    var id_store: Int
)