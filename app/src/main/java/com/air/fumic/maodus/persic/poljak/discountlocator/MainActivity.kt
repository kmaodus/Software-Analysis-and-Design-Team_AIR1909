package com.air.fumic.maodus.persic.poljak.discountlocator

import android.R.*
import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.row_main.view.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val showButton = findViewById<Button>(R.id.btnShow)
        val listView = findViewById<ListView>(R.id.list_view_Stores)

        btnShow.setOnClickListener() {
            listView.adapter = MyCustomAdapter()
        }
    }

    class MyCustomAdapter : BaseAdapter() {
        //private val mContext: Context = context
        private val storeNames = arrayListOf<String>("Varteks", "Super Nova", "Lidl")

        public fun getStoreNames(): ArrayList<String> {
            return storeNames
        }

        override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup): View {
            val rowMain: View

            if (convertView == null) {
                val layoutInflater = LayoutInflater.from(viewGroup.context)
                rowMain = layoutInflater.inflate(R.layout.row_main, viewGroup, false)

                //val storesTextView = rowMain.findViewById<TextView>(R.id.stores_textview)
                //val positionTextView = rowMain.findViewById<TextView>(R.id.position_textview)
                val viewHolder = ViewHolder(rowMain.stores_textview, rowMain.position_textview)
                rowMain.tag = viewHolder
            } else {
                rowMain = convertView
            }
            val viewHolder = rowMain.tag as ViewHolder
            viewHolder.nameTextView.text = storeNames.get(position)
            val rowPosition = position.inc()
            viewHolder.positionTextView.text = "Row number: $rowPosition"
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

        private class ViewHolder(val nameTextView: TextView, val positionTextView: TextView)

    }
}