package com.gdsdevtec.cineapp.presenter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.gdsdevtec.cineapp.R
import com.gdsdevtec.cineapp.databinding.ActivityMainBinding
import com.gdsdevtec.cineapp.presenter.auth.register.RegisterFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContentView(binding.root)
        val registerFragment = RegisterFragment()
        val fragment = supportFragmentManager.beginTransaction()
        val add = fragment.add(R.id.container, registerFragment)
        add.commit()
    }
}