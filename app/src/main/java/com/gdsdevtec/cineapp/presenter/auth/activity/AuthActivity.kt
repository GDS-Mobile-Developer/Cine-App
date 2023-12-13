package com.gdsdevtec.cineapp.presenter.auth.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gdsdevtec.cineapp.R
import com.gdsdevtec.cineapp.presenter.main.activity.MainActivity
import com.gdsdevtec.cineapp.utils.FirebaseHelper
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class  AuthActivity : AppCompatActivity(R.layout.activity_auth){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        isAuthenticate()
    }

    private fun isAuthenticate() {
        if (FirebaseHelper.isAuthenticated()) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}