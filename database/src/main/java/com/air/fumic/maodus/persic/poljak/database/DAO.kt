package com.air.fumic.maodus.persic.poljak.database

import com.air.fumic.maodus.persic.poljak.database.entities.*

interface DAO {

    //INSERT functions
    fun insertUser(user: User)

    fun insertStore(store: Store)

    fun insertProduct(product: Product)

    fun insertOffer(offer: Offer)

    fun insertDiscount(discount: Discount)

    fun insertChart(chart: Chart)

    //SELECT functions
    fun selectUsers(): MutableList<User>

    fun selectStore(): MutableList<Store>

    fun selectProduct(): MutableList<Product>

    fun selectOffer(): MutableList<Offer>

    fun selectDiscount(): MutableList<Discount>

    fun selectChart(): MutableList<Chart>

    //DELETE functions
    fun deleteUser(user_id: Int)

    fun deleteStore(store_id: Int)

    fun deleteProduct(product_id: Int)

    fun deleteOffer(offer_id: Int)

    fun deleteDiscount(discount_id: Int)

    fun deleteChart(chart_id: Int)
}