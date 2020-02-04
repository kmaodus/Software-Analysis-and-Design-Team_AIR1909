package com.example.core

import com.air.fumic.maodus.persic.poljak.database.entities.*

interface DataLoadedListener {
    fun onDataLoaded(
        stores: List<Store>,
        discounts: List<Discount>
    )
}