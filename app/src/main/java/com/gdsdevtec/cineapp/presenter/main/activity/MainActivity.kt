package com.gdsdevtec.cineapp.presenter.main.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.gdsdevtec.cineapp.R
import com.gdsdevtec.cineapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContentView(binding.root)
        initNavigation()
    }

    private fun initNavigation() {
        var navHostFragment =
            supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment
        navController = navHostFragment.navController
        NavigationUI.setupWithNavController(binding.bottomNavigationMain, navController)
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            binding.bottomNavigationMain.isVisible =
                destination.id == R.id.menu_home ||
                        destination.id == R.id.menu_search ||
                        destination.id == R.id.menu_favorite ||
                        destination.id == R.id.menu_download ||
                        destination.id == R.id.menu_profile
        }
    }
}