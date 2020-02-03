package com.air.fumic.maodus.persic.poljak.discountlocator

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val showButton = findViewById<Button>(R.id.btnShow)
        //val listView = findViewById<ListView>(R.id.list_view_Stores)
        //listView.adapter = MyCustomAdapter()

        /*btnShow.setOnClickListener() {
            listView.adapter = MyCustomAdapter()
        }*/
    }

    fun showListView(view: View) {

        val intent = Intent(this, DisplayListActivity::class.java).also {
            startActivity(it)
        }
    }


}