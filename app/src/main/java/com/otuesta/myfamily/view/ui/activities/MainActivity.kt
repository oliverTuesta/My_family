package com.otuesta.myfamily.view.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.otuesta.myfamily.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setActionBar(findViewById(R.id.tbMain))

        configNav()
    }

    private fun configNav() {
        val bnvMenu = findViewById<BottomNavigationView>(R.id.bnvMenu) as BottomNavigationView
        NavigationUI.setupWithNavController(
            bnvMenu, Navigation.findNavController(
                this,
                R.id.fragContent
            )
        )
    }


}