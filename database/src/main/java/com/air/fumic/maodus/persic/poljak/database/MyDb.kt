package com.air.fumic.maodus.persic.poljak.database

import android.util.Log
import com.air.fumic.maodus.persic.poljak.database.entities.*
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MyDb : DAO{

    //connection to database
    val database = FirebaseDatabase.getInstance().reference

    //INSERT functions
    override fun insertUser(user: User){
        database.child("users").child(user.id_user.toString()).setValue(user)
    }

    override fun insertStore(store: Store){
        database.child("store").child(store.id_store.toString()).setValue(store)
    }

    override fun insertProduct(product: Product){
        database.child("product").child(product.id_product.toString()).setValue(product)
    }

    override fun insertOffer(offer: Offer){
        database.child("offer").child(offer.id_offer.toString()).setValue(offer)
    }

    override fun insertDiscount(discount: Discount){
        database.child("discount").child(discount.id_discount.toString()).setValue(discount)
    }

    override fun insertChart(chart: Chart){
        database.child("chart").child(chart.id_chart.toString()).setValue(chart)
    }

    //SELECT * functions
    override fun selectUsers(): MutableList<User> {
        var users_list = mutableListOf<User>()
        val listener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (user: DataSnapshot in dataSnapshot.children){
                    Log.i("users", user.toString())
                    var id_user = user.child("id_user").value.toString().toInt()
                    var username = user.child("username").value.toString()
                    var name = user.child("name").value.toString()
                    var surname = user.child("surname").value.toString()
                    var adress = user.child("adress").value.toString()
                    var emali = user.child("email").value.toString()
                    var password = user.child("password").value.toString()

                    var new_user = User(id_user = id_user, username = username, name = name, surname = surname, adress = adress, email = emali, password = password)
                    users_list.add(new_user)
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                Log.e("error", "Getting data failed.")
            }

        }

        database.child("users").addValueEventListener(listener)
        return users_list
    }

    override fun selectStore(): MutableList<Store> {
        var stores_list = mutableListOf<Store>()
        val listener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (user: DataSnapshot in dataSnapshot.children){
                    Log.i("users", user.toString())
                    var id_store = user.child("id_store").value.toString().toInt()
                    var phone_number = user.child("phone_number").value.toString()
                    var name = user.child("name").value.toString()
                    var adress = user.child("adress").value.toString()
                    var emali = user.child("email").value.toString()
                    var longitude = user.child("longitude").value.toString()
                    var laditude = user.child("laditude").value.toString()
                    var working_hours_from = user.child("working_hours_from").value.toString()
                    var working_hours_to = user.child("working_hours_to").value.toString()
                    var description = user.child("description").value.toString()

                    var new_store = Store(id_store = id_store, name = name, adress = adress, email = emali, phone_number = phone_number, longitude = longitude, latitude = laditude, working_hours_from = working_hours_from, working_hours_to = working_hours_to, description = description)
                    stores_list.add(new_store)
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                Log.e("error", "Getting data failed.")
            }

        }

        database.child("stores").addValueEventListener(listener)
        return stores_list
    }

    override fun selectProduct(): MutableList<Product> {
        var product_list = mutableListOf<Product>()
        val listener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (product: DataSnapshot in dataSnapshot.children){
                    Log.i("users", product.toString())
                    var id_product = product.child("id_product").value.toString().toInt()
                    var name = product.child("name").value.toString()
                    var description = product.child("description").value.toString()

                    var new_product = Product(id_product = id_product, name = name, description = description)
                    product_list.add(new_product)
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                Log.e("error", "Getting data failed.")
            }

        }

        database.child("product").addValueEventListener(listener)
        return product_list
    }

    override fun selectOffer(): MutableList<Offer> {
        var offer_list = mutableListOf<Offer>()
        val listener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (offer: DataSnapshot in dataSnapshot.children){
                    Log.i("users", offer.toString())
                    var id_offer = offer.child("id_offer").value.toString().toInt()
                    var amount = offer.child("amount").value.toString().toInt()
                    var price = offer.child("price").value.toString().toDouble()
                    var id_store = offer.child("id_store").value.toString().toInt()
                    var id_product = offer.child("id_product").value.toString().toInt()

                    var new_offer = Offer(id_offer = id_offer, amount = amount, price = price, id_store = id_store, id_product = id_product)
                    offer_list.add(new_offer)
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                Log.e("error", "Getting data failed.")
            }

        }

        database.child("offer").addValueEventListener(listener)
        return offer_list
    }

    override fun selectDiscount(): MutableList<Discount> {
        var discount_list = mutableListOf<Discount>()
        val listener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (discount: DataSnapshot in dataSnapshot.children){
                    Log.i("users", discount.toString())
                    var id_discount = discount.child("id_discount").value.toString().toInt()
                    var amount = discount.child("discount_amount").value.toString().toDouble()
                    var date_from = discount.child("date_from").value.toString()
                    var date_to = discount.child("date_to").value.toString()
                    var id_offer = discount.child("id_offer").value.toString().toInt()

                    var new_offer = Discount(id_discount = id_discount, discount_amount = amount, date_from = date_from, date_to = date_to, id_offer = id_offer)
                    discount_list.add(new_offer)
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                Log.e("error", "Getting data failed.")
            }

        }

        database.child("discount").addValueEventListener(listener)
        return discount_list
    }

    override fun selectChart(): MutableList<Chart> {
        var chart_list = mutableListOf<Chart>()
        val listener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (chart: DataSnapshot in dataSnapshot.children){
                    Log.i("users", chart.toString())
                    var id_chart = chart.child("id_chart").value.toString().toInt()
                    var amount = chart.child("discount_amount").value.toString().toInt()
                    var id_user = chart.child("id_user").value.toString().toInt()
                    var id_discount = chart.child("id_discount").value.toString().toInt()

                    var new_chart = Chart(id_chart = id_chart, amount = amount, id_user = id_user, id_discount = id_discount)
                    chart_list.add(new_chart)
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                Log.e("error", "Getting data failed.")
            }

        }

        database.child("chart").addValueEventListener(listener)
        return chart_list
    }

    //DELETE functions
    override fun deleteUser(user_id: Int){
        database.child("users").child(user_id.toString()).removeValue()
    }

    override fun deleteStore(store_id: Int){
        database.child("store").child(store_id.toString()).removeValue()
    }

    override fun deleteProduct(product_id: Int){
        database.child("product").child(product_id.toString()).removeValue()
    }

    override fun deleteOffer(offer_id: Int){
        database.child("users").child(offer_id.toString()).removeValue()
    }

    override fun deleteDiscount(discount_id: Int){
        database.child("discount").child(discount_id.toString()).removeValue()
    }

    override fun deleteChart(chart_id: Int){
        database.child("chart").child(chart_id.toString()).removeValue()
    }
}