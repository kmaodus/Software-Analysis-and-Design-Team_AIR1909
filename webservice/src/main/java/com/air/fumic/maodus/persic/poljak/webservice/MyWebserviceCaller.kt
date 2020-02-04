package com.air.fumic.maodus.persic.poljak.webservice


import com.air.fumic.maodus.persic.poljak.webservice.responses.MyWebserviceResponse
import com.example.core.DataClasses.Discount
import com.example.core.DataClasses.Store
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyWebserviceCaller {

    val retrofit = Retrofit.Builder()
        .baseUrl(BaseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getStoresData(): Array<Store>?{
        val service = retrofit.create(MyWebservice::class.java)
        val call = service.getStores(Method)

        var allStores: Array<Store>? = null

        call.enqueue(object: Callback<MyWebserviceResponse>{
            override fun onResponse(
                call: Call<MyWebserviceResponse>?,
                response: Response<MyWebserviceResponse>
            ) {
                allStores = processStoresResponse(response)
            }

            override fun onFailure(call: Call<MyWebserviceResponse>?, t: Throwable?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })
        return allStores
    }

    fun getDiscountsData(): Array<Discount>?{
        val service = retrofit.create(MyWebservice::class.java)
        val call = service.getDiscounts(Method)

        var allDiscounts: Array<Discount>? = null

        call.enqueue(object: Callback<MyWebserviceResponse>{
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

    companion object{
        var BaseUrl = "http://cortex.foi.hr/mtl/courses/air/"
        var Method = "getAll"
    }
}