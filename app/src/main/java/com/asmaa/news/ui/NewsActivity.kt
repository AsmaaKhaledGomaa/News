package com.asmaa.news.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.asmaa.news.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class NewsActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)


      val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
          navController = navHostFragment.navController
      val bottomNavigationView=findViewById<BottomNavigationView>(R.id.bottomNavigationView)
          bottomNavigationView.setupWithNavController(navController)


        navController.addOnDestinationChangedListener { _, destination, _ ->
            if(destination.id == R.id.splashFragment) {

                bottomNavigationView.visibility = View.GONE
            } else {

                bottomNavigationView.visibility = View.VISIBLE
            }
        }
    }
}