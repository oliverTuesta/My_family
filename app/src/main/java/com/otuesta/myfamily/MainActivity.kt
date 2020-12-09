package com.otuesta.myfamily

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setActionBar(findViewById(R.id.tbMain))

        val bnvMenu = findViewById<BottomNavigationView>(R.id.bnvMenu) as BottomNavigationView

        configNav(bnvMenu)

    }

    private fun configNav(bnvMenu: BottomNavigationView) {
        NavigationUI.setupWithNavController(bnvMenu, Navigation.findNavController(this, R.id.fragContent))
    }


}