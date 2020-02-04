package com.air.fumic.maodus.persic.poljak.discountlocator.loaders

import com.air.fumic.maodus.persic.poljak.database.entities.Store
import com.air.fumic.maodus.persic.poljak.discountlocator.MainActivity
import com.example.core.DataLoader

class DataLoaderFactory {

    fun getDataLoader(): DataLoader?{
        var dataLoader: DataLoader? = null
        var stores: List<Store> = MainActivity.database.getDAO().getStores()

        if (!stores.isEmpty()){
            dataLoader = DbDataLoader()
        }/*else{
            dataLoader = WsDataLoader()
        }*/

        return dataLoader
    }
}