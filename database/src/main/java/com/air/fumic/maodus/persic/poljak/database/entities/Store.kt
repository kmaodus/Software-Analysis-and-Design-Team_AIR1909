package com.air.fumic.maodus.persic.poljak.database.entities

data class Store (
    var id_store: Int,
    var name: String,
    var adress: String,
    var email: String,
    var phone_number: String,
    var latitude: String,
    var longitude: String,
    var working_hours_from: String,
    var working_hours_to: String,
    var description: String
)