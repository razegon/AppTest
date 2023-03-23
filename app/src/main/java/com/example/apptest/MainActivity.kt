package com.example.apptest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI

import com.example.apptest.databinding.ActivityMainBinding
import com.example.apptest.fragments.*
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(ArchZonesFragment())

//        val navHostFragment =
//            supportFragmentManager.findFragmentById(R.id.nav_host_fragment)as NavHostFragment
//        val navController = navHostFragment.navController
//        findViewById<BottomNavigationView>(R.id.bottomNavigationView)
//            .setupWithNavController(navController)
        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        NavigationUI.setupWithNavController(binding.bottomNavigationView!!, navController)
        val layoutParams =
            binding.bottomNavigationView!!.layoutParams as CoordinatorLayout.LayoutParams
        layoutParams.behavior = NavigationViewBehavior()
        val params = binding.frameLayout.layoutParams as ViewGroup.MarginLayoutParams

        //hide bottom navigation no need while sun activities are being used
        navController.addOnDestinationChangedListener { _,
                                                        destination: NavDestination, arguments: Bundle? ->
            if (destination.id == R.id.archZonesFragment) {
                params.setMargins(0, 0, 0, 20)
                binding.frameLayout.layoutParams = params
                binding.bottomNavigationView!!.visibility = View.VISIBLE
                binding.bottomNavigationView.isVisible =
                    arguments?.getBoolean("ShowBottomNavView", false) == true

            } else if (destination.id == R.id.placesDetailsFragment) {
                params.setMargins(0, 0, 0, 0)
                binding.frameLayout.layoutParams = params
                binding.bottomNavigationView!!.visibility = View.INVISIBLE
                binding.bottomNavigationView.isVisible =
                    arguments?.getBoolean("ShowBottomNavView", true) == false

            } else {
                params.setMargins(0, 0, 0, 0)
                binding.frameLayout.layoutParams = params
                binding.bottomNavigationView!!.visibility = View.GONE
            }
        }

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home_label -> replaceFragment(Home())
                R.id.cities_label -> replaceFragment(CitiesFragment())
                R.id.archZones_label -> replaceFragment(ArchZonesFragment())
                R.id.nature_label -> replaceFragment(NatureFragment())
                else -> {}
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }


}





