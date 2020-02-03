package com.air.fumic.maodus.persic.poljak.discountlocator

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        notificationSetup()
        MobileAds.initialize(this, getString(R.string.admob_app_id))
        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)

        //val showButton = findViewById<Button>(R.id.btnShow)
        //val listView = findViewById<ListView>(R.id.list_view_Stores)
        //listView.adapter = MyCustomAdapter()

        /*btnShow.setOnClickListener() {
            listView.adapter = MyCustomAdapter()
        }*/
    }

    fun showListView(view: View) {
        val intent = Intent(this, DisplayListActivity::class.java).also {
            startActivity(it)
        }
    }

    fun notificationSetup() {
        FirebaseMessaging.getInstance().isAutoInitEnabled = true
        FirebaseInstanceId.getInstance().instanceId
            .addOnCompleteListener(OnCompleteListener { task ->
                if (!task.isSuccessful) {
                    return@OnCompleteListener
                }
                val token = task.result?.token
                //Toast.makeText(baseContext, token, Toast.LENGTH_SHORT).show()
            })
    }


}