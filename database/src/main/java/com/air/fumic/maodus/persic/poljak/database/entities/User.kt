package com.air.fumic.maodus.persic.poljak.database.entities

data class User (
    var id_user: Int,
    var name: String,
    var surname: String,
    var username: String,
    var email: String,
    var password: String,
    var adress: String
)