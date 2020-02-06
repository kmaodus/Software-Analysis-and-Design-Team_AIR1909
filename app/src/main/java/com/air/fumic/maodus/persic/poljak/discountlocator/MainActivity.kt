package com.air.fumic.maodus.persic.poljak.discountlocator

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentTransaction
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.material.navigation.NavigationView
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var toolbar: Toolbar
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navView: NavigationView
    private lateinit var listViewFragment: ListViewFragment
    private lateinit var mapViewFragment: MapViewFragment
    private lateinit var aboutAppFragment: AboutAppFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(this.toolbar)

        drawerLayout = findViewById(R.id.drawer_layout)
        navView = findViewById(R.id.nav_view)

        val toogle = ActionBarDrawerToggle(this, drawerLayout, toolbar, 0, 0)


        toogle.isDrawerIndicatorEnabled = true
        drawerLayout.addDrawerListener(toogle)
        toogle.syncState()
        nav_view.setNavigationItemSelectedListener(this)

        notificationSetup()

        //fragment code - ListViewFragment is the main fragment
        listViewFragment = ListViewFragment()
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, listViewFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
        //mapViewFragment = MapViewFragment()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.options_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        /*var selectedOption = ""
        when (item.itemId) {
            R.id.about -> selectedOption = "About"
        }
        Toast.makeText(this, "Option: " + selectedOption, Toast.LENGTH_LONG).show()
        return super.onOptionsItemSelected(item)*/

        if (item.itemId == R.id.settings) {
            // launch settings activity
            startActivity(Intent(this@MainActivity, SettingsActivity::class.java))
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_listView -> {
                listViewFragment = ListViewFragment()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, listViewFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
            }
            R.id.nav_mapView -> {
                mapViewFragment = MapViewFragment()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, mapViewFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
            }
            R.id.nav_aboutApp -> {
                aboutAppFragment = AboutAppFragment()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, aboutAppFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
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