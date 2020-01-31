package com.example.core.DataClasses

data class Discount(
    val id: Int,
    val storeId: Int,
    val name: String,
    val description: String,
    val discountValue: Int,
    val startDate: String,
    val endDate: String
)