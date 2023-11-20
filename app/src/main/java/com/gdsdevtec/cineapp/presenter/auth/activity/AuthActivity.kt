package com.gdsdevtec.cineapp.presenter.auth.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gdsdevtec.cineapp.databinding.ActivityAuthBinding

class AuthActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityAuthBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}