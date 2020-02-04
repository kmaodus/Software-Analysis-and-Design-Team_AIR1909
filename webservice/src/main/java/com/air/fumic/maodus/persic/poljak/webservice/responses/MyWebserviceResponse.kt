package com.air.fumic.maodus.persic.poljak.webservice.responses

import com.google.gson.annotations.SerializedName

class MyWebserviceResponse {
    @SerializedName("responseId")
    var responseId: Int = 0
    @SerializedName("responseText")
    var responseText: String? = null
    @SerializedName("timeStamp")
    var timeStamp: Int = 0
    @SerializedName("items")
    var items: String? = null
}