package com.gdsdevtec.cineapp.presenter.auth.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gdsdevtec.cineapp.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private lateinit var binding : FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    )=FragmentLoginBinding.inflate(
        inflater,container,false
    ).root.also {
        binding = FragmentLoginBinding.bind(it)
    }
}