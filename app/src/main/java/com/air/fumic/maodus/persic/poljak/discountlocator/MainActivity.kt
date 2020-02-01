package com.air.fumic.maodus.persic.poljak.discountlocator

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.list_view_Stores)
        listView.adapter = MyCustomAdapter(this)
    }

    class MyCustomAdapter(context: Context) : BaseAdapter() {
        private val mContext: Context = context
        private val storeNames = arrayListOf<String>("Varteks", "Super Nova")

        override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup): View {
            val layoutInflater = LayoutInflater.from(mContext)
            val rowMain = layoutInflater.inflate(R.layout.row_main, viewGroup, false)

            val storesTextView = rowMain.findViewById<TextView>(R.id.stores_textview)
            storesTextView.text = storeNames.get(position)
            val positionTextView = rowMain.findViewById<TextView>(R.id.position_textview)
            positionTextView.text = "Row number: $position"
            return rowMain
        }

        override fun getItem(position: Int): Any {
            return "TEST STRING"
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return storeNames.size
        }
    }
}
