package com.example.core

import com.air.fumic.maodus.persic.poljak.database.entities.*

interface DataLoadedListener {
    fun onDataLoaded(
        users: List<User>,
        stores: List<Store>,
        products: List<Product>,
        discounts: List<Discount>,
        offers: List<Offer>,
        charts: List<Chart>
    )
}