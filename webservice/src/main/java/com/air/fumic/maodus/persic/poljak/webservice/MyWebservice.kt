package com.air.fumic.maodus.persic.poljak.webservice

import com.air.fumic.maodus.persic.poljak.webservice.responses.MyWebserviceResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST


interface MyWebservice {
    @FormUrlEncoded
    @POST("stores.php")
    fun getStores(@Field("method") method: String): Call<MyWebserviceResponse>

    @FormUrlEncoded
    @POST("discounts.php")
    fun getDiscounts(@Field("method") method: String): Call<MyWebserviceResponse>
}