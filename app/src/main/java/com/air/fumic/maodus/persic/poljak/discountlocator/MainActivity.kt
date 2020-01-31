package com.air.fumic.maodus.persic.poljak.discountlocator

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.TextView
import java.security.AccessControlContext
import android.widget.ListView as ListView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.list_view_Stores)
        listView.adapter = MyCustomAdapter(this)

        /*val storesList = Recipe.getRecipesFromFile("recipes.json", this)
        val listItems = arrayOfNulls<String>(storesList.size)
        for (i in 0 until recipeList.size) {
            val recipe = recipeList[i]
            listItems[i] = recipe.title
        }
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems)
        listView.adapter = adapter*/

        /*fun generateFakeValues(): List<String> {
           val data = ArrayList<String>()
           for (i in 0..4) {
               data.add("Trgovina broj $i")
           }
           return data
       }

       private class CustomAdapter(context: Context, private var values:List<String>):
           ArrayAdapter<String>(context, R.layout.list_stores_view) {

           override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
               val rowView = LayoutInflater.from(context).inflate(R.layout.list_stores_view, parent, false)
               val textView: TextView = rowView.findViewById(R.id.txtViewListStores)
               textView.text = values[position]
               return rowView
           }
       }*/

    }

    class MyCustomAdapter(context: Context) : BaseAdapter() {

        private val mContext: Context = context

        override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup): View {
            val textView = TextView(mContext)
            textView.text = "Ovo je jedan red u listi"
            return textView
        }

        override fun getItem(position: Int): Any {
            return "TEST STRING"
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return 8
        }
    }

}
