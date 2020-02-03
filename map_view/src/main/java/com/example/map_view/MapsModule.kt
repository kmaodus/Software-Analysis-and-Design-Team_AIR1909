package com.example.map_view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.air.fumic.maodus.persic.poljak.webservice.MyWebservice
import com.air.fumic.maodus.persic.poljak.webservice.MyWebserviceCaller
import com.air.fumic.maodus.persic.poljak.webservice.responses.MyWebserviceResponse
import com.example.core.DataClasses.Store
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions

class MapsModule : AppCompatActivity(), OnMapReadyCallback{

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps_module)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val kapucinski = LatLng(46.305173, 16.336326)
        mMap.addMarker(MarkerOptions().position(kapucinski).title("Kapucinski trg"))

        val angelus = LatLng(46.307349, 16.339824)
        mMap.addMarker(MarkerOptions().position(angelus).title("Angelus"))

        setMarkers()
        mMap.moveCamera(CameraUpdateFactory.newLatLng(kapucinski))
        mMap.setMinZoomPreference(12.0f)

    }

    fun setMarkers(){
        val webService = MyWebserviceCaller()
        Log.i("stores", "ALL stores:")

        var stores: Array<Store>? = webService.getStoresData()

        if (stores != null){
            for (store: Store in stores){
                Log.i("stores", "Proba")
                Log.i("stores", store.name)
            }
        }else Log.i("stores", "Stores is null!")
    }
}
