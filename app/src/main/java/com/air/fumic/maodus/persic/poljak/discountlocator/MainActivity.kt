package com.air.fumic.maodus.persic.poljak.discountlocator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.air.fumic.maodus.persic.poljak.database.MyDb
import com.air.fumic.maodus.persic.poljak.webservice.MyWebservice
import com.air.fumic.maodus.persic.poljak.webservice.MyWebserviceCaller
import com.air.fumic.maodus.persic.poljak.webservice.responses.MyWebserviceResponse
import com.example.core.DataClasses.Discount
import com.example.core.DataClasses.Store
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


private val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    public var database: MyDb = MyDb().getInstance()

    private lateinit var storeAdapter: StoreRecyclerAdapter
    val myWebserviceCaller = MyWebserviceCaller()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val dataLoader : DataLoader = DbDataLoader()
        //val database : DAO = MyDb()

        //initializeRecyclerView()
        //addDataSetForRecyclerView()
        getStoresData()
    }

    private fun addDataSetForRecyclerView(){
        myWebserviceCaller.getStoresData()
        //val data = myWebserviceCaller.getStoresData()
        //val dataList = data!!.toList()
        //storeAdapter.submitList(dataList)
    }

    private fun initializeRecyclerView(dataList: List<Store>){
        recycler_view.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            val topSpacingItemDecoration = TopSpacingItemDecoration(30)
            addItemDecoration(topSpacingItemDecoration)
            storeAdapter = StoreRecyclerAdapter()
            storeAdapter.submitList(dataList)
            recycler_view.adapter = storeAdapter
        }
    }


    // WEBSERVICE CONSUMING
    fun getStoresData(){
        val retrofit = Retrofit.Builder()
            .baseUrl(MyWebserviceCaller.BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(MyWebservice::class.java)
        val call = service.getStores(MyWebserviceCaller.Method)

        //var allStores: Array<Store>? = null

        call.enqueue(object: Callback<MyWebserviceResponse> {
            override fun onResponse(
                call: Call<MyWebserviceResponse>?,
                response: Response<MyWebserviceResponse>
            ) {
                if(response.code() == 200){
                    val jsonStores = response.body()
                    initializeRecyclerView(processStoresResponse(response).toList())
                    //allStores = processStoresResponse(response)
                }
            }

            override fun onFailure(call: Call<MyWebserviceResponse>?, t: Throwable?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })
        //return allStores
    }

    fun getDiscountsData(): Array<Discount>{
        val retrofit = Retrofit.Builder()
            .baseUrl(MyWebserviceCaller.BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(MyWebservice::class.java)
        val call = service.getDiscounts(MyWebserviceCaller.Method)

        lateinit var allDiscounts: Array<Discount>

        call.enqueue(object: Callback<MyWebserviceResponse> {
            override fun onResponse(
                call: Call<MyWebserviceResponse>?,
                response: Response<MyWebserviceResponse>
            ) {
                allDiscounts = processDiscountsResponse(response)
            }

            override fun onFailure(call: Call<MyWebserviceResponse>?, t: Throwable?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })
        return allDiscounts
    }

    fun processStoresResponse(response: Response<MyWebserviceResponse>): Array<Store>{
        var gson: Gson = Gson()
        var allStores: Array<Store> = gson.fromJson(
            response.body().items, Array<Store>::class.java
        )
        return allStores
    }

    fun processDiscountsResponse(response: Response<MyWebserviceResponse>): Array<Discount>{
        var gson: Gson = Gson()
        var allDiscounts: Array<Discount> = gson.fromJson(
            response.body().items, Array<Discount>::class.java
        )
        return allDiscounts
    }
}
