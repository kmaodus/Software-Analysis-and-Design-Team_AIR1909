package com.air.fumic.maodus.persic.poljak.discountlocator.loaders

import com.example.core.DataLoadedListener
import com.example.core.DataLoader
import com.air.fumic.maodus.persic.poljak.database.MyDb

class DbDataLoader: DataLoader {
    var data_loaded = false

    override fun loadData(listener: DataLoadedListener) {
        var dao = MyDb()

        var users = dao.selectUsers()
        var stores = dao.selectStore()
        var products = dao.selectProduct()
        var offers = dao.selectOffer()
        var discounts = dao.selectDiscount()
        var charts = dao.selectChart()
        data_loaded = true

        listener.onDataLoaded(users, stores, products, discounts, offers, charts)
    }

    override fun isDataLoaded(): Boolean {
        return data_loaded
    }
}