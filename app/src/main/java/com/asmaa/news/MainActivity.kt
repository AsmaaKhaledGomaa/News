package com.asmaa.news

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.navigation.fragment.NavHostFragment
import com.asmaa.news.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
//private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater, null, false)
        setContentView(binding.root)
        // navController = findNavController(R.id.navHostFragment)
        //  binding.bottomNavigationView.setupWithNavController(navController)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        val navController = navHostFragment.navController

//        navController.addOnDestinationChangedListener { controller, destination, arguments ->
//            when (destination.id) {
//                R.id.newsFragment->
//                    binding.bottomNavigationView.isVisible = false
//                else -> binding.bottomNavigationView.isVisible = true
//            }
//        }
    }
}