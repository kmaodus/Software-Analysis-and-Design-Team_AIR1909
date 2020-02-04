package com.air.fumic.maodus.persic.poljak.database

import android.util.Log
import com.air.fumic.maodus.persic.poljak.database.entities.*
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MyDb{

    //connection to database
    val database = FirebaseDatabase.getInstance().reference

    public fun getInstance() : MyDb {
        return this
    }

    //INSERT functions

    fun insertStore(store: Store){
        database.child("store").child(store.id.toString()).setValue(store)
    }

    fun insertDiscount(discount: Discount){
        database.child("discount").child(discount.id.toString()).setValue(discount)
    }

    //SELECT * functions
    fun selectStore(): MutableList<Store> {
        var stores_list = mutableListOf<Store>()
        val listener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (user: DataSnapshot in dataSnapshot.children){
                    Log.i("users", user.toString())
                    var id_store = user.child("id_store").value.toString().toInt()
                    var name = user.child("name").value.toString()
                    var url = user.child("adress").value.toString()
                    var description = user.child("adress").value.toString()
                    var longitude = user.child("longitude").value.toString()
                    var laditude = user.child("laditude").value.toString()
                    var working_hours_from = user.child("working_hours_from").value.toString()
                    var working_hours_to = user.child("working_hours_to").value.toString()

                    var new_store = Store(id = id_store, name = name, description = description, url = url, longitude = longitude, latitude = laditude, working_hours_from = working_hours_from, working_hours_to = working_hours_to)
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

    fun selectDiscount(): MutableList<Discount> {
        var discount_list = mutableListOf<Discount>()
        val listener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (discount: DataSnapshot in dataSnapshot.children){
                    Log.i("users", discount.toString())
                    var id_discount = discount.child("id_discount").value.toString().toInt()
                    var amount = discount.child("discount_amount").value.toString().toInt()
                    var date_from = discount.child("date_from").value.toString()
                    var date_to = discount.child("date_to").value.toString()
                    var id_store = discount.child("id_offer").value.toString().toInt()
                    var name = discount.child("id_offer").value.toString()

                    var new_offer = Discount(id = id_discount, discount = amount, name = name, start_date = date_from, end_date = date_to, id_store = id_store)
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

    //DELETE functions
    fun deleteStore(store_id: Int){
        database.child("store").child(store_id.toString()).removeValue()
    }

    fun deleteDiscount(discount_id: Int){
        database.child("discount").child(discount_id.toString()).removeValue()
    }
}