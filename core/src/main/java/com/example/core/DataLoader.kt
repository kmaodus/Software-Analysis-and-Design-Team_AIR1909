package com.example.core

interface DataLoader {
    fun loadData(listener: DataLoadedListener)
    fun isDataLoaded(): Boolean
}