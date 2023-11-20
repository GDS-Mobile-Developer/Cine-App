package com.gdsdevtec.cineapp.presenter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.gdsdevtec.cineapp.R
import com.gdsdevtec.cineapp.databinding.ActivityMainBinding
import com.gdsdevtec.cineapp.presenter.auth.forgot.ForgotFragment
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
        val registerFragment = ForgotFragment()
        val fragment = supportFragmentManager.beginTransaction()
        val add = fragment.add(R.id.container, registerFragment)
        add.commit()
    }
}