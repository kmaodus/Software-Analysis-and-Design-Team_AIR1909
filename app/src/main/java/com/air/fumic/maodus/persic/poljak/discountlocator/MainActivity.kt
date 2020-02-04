package com.air.fumic.maodus.persic.poljak.discountlocator

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.air.fumic.maodus.persic.poljak.database.MyDatabase

class MainActivity : AppCompatActivity() {

    companion object{
        lateinit var context: Context
        lateinit var database: MyDatabase
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        context = this
        database = MyDatabase.invoke(this)
    }
}
