package com.air.fumic.maodus.persic.poljak.discountlocator.loaders

import com.air.fumic.maodus.persic.poljak.database.MyDatabase
import com.example.core.DataLoadedListener
import com.example.core.DataLoader
import com.air.fumic.maodus.persic.poljak.database.entities.Discount
import com.air.fumic.maodus.persic.poljak.database.entities.Store
import com.air.fumic.maodus.persic.poljak.discountlocator.MainActivity

class DbDataLoader: DataLoader {
    private var dataLoaded:Boolean = false

    override fun loadData(listener: DataLoadedListener) {
        val database = MyDatabase(MainActivity.context)
        var dao = database.getDAO()

        var stores: List<Store> = dao.getStores()
        var discounts: List<Discount> = dao.getDiscounts()

        dataLoaded = true
        listener.onDataLoaded(stores = stores, discounts = discounts)
    }

    override fun isDataLoaded(): Boolean {
        return dataLoaded
    }
}