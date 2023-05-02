package com.example.practical

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_nav_view)
        val navControllerManager = supportFragmentManager.findFragmentById(R.id.fragmentContainerView2) as NavHostFragment
    val navController = navControllerManager.navController
val appBarConfiguration = AppBarConfiguration(navController.graph)
setupActionBarWithNavController(navController,appBarConfiguration)

    }
}