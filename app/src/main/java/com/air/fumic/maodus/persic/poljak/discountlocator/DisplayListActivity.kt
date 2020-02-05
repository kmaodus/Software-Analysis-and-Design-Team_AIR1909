package com.air.fumic.maodus.persic.poljak.discountlocator

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.air.fumic.maodus.persic.poljak.discountlocator.adapters.MyCustomAdapter

class DisplayListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_list)

        val listView = findViewById<ListView>(R.id.list_view_Stores)
        listView.adapter = MyCustomAdapter()
    }
}
