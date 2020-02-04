package com.example.core

import com.air.fumic.maodus.persic.poljak.database.entities.*

interface DataPresenter {
    fun setData(stores: List<Store>, discounts: List<Discount>)
}