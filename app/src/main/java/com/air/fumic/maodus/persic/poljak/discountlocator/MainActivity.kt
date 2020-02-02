package com.air.fumic.maodus.persic.poljak.discountlocator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.air.fumic.maodus.persic.poljak.database.DAO
import com.air.fumic.maodus.persic.poljak.database.MyDb
import com.air.fumic.maodus.persic.poljak.discountlocator.loaders.DbDataLoader
import com.air.fumic.maodus.persic.poljak.webservice.MyWebserviceCaller
import com.example.core.DataLoader
import kotlinx.android.synthetic.main.activity_main.*


private val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    public var database: MyDb = MyDb().getInstance()

    private lateinit var storeAdapter: StoreRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataLoader : DataLoader = DbDataLoader()
        val database : DAO = MyDb()
        val myWebservice = MyWebserviceCaller()

        initializeRecyclerView()
        addDataSetForRecyclerView()
    }

    private fun addDataSetForRecyclerView(){

    }

    private fun initializeRecyclerView(){
        recycler_view.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            storeAdapter = StoreRecyclerAdapter()
            recycler_view.adapter = storeAdapter
        }
    }
}
