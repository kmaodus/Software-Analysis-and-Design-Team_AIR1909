package com.example.core

import com.air.fumic.maodus.persic.poljak.database.entities.*

interface DataPresenter {
    fun setData(users: List<User>, stores: List<Store>, products: List<Product>, offers: List<Offer>, discounts: List<Discount>, charts: List<Chart>)
}