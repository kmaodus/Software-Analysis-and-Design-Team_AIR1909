package com.air.fumic.maodus.persic.poljak.discountlocator

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.air.fumic.maodus.persic.poljak.database.DAO
import com.air.fumic.maodus.persic.poljak.database.MyDb
import com.air.fumic.maodus.persic.poljak.discountlocator.loaders.DbDataLoader
import com.example.core.DataLoader
import com.example.map_view.MapsModule


private val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    public var database: MyDb = MyDb().getInstance()


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        //google maps proba
        var intent = Intent(this, MapsModule:: class.java)
        startActivity(intent)

        /*
        val dataLoader : DataLoader = DbDataLoader()

        val database : DAO = MyDb()

        val testButton: Button = findViewById(R.id.show_discounts_button)
        val listView: ListView = findViewById(R.id.discount_list)

        val currentContext: Context = this

        testButton.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                val listOfStrings = mutableListOf<String>("first", "second")

                val adapter = ArrayAdapter(currentContext, android.R.layout.simple_list_item_1, listOfStrings)
                listView.adapter = adapter

                Log.d(TAG, "Successful click")
            }
        })

        */
    }
}
