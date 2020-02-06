package com.air.fumic.maodus.persic.poljak.discountlocator

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceFragmentCompat

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.settings, MainPreferenceFragment())
            .commit()
    }

    class MainPreferenceFragment : PreferenceFragmentCompat() {
        /*override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            addPreferencesFromResource(R.xml.root_preferences)

            // gallery EditText change listener

            // notification preference change listener
        }*/

        override fun onCreatePreferences(savedInstanceState: Bundle, rootKey: String?) {
            addPreferencesFromResource(R.xml.root_preferences)
        }


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}

