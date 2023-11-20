package com.gdsdevtec.cineapp.presenter.auth.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gdsdevtec.cineapp.databinding.FragmentHomeAuthBinding
import com.gdsdevtec.cineapp.utils.nextFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeAuthFragment : Fragment() {
    private lateinit var binding: FragmentHomeAuthBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ) = FragmentHomeAuthBinding.inflate(
        inflater, container, false
    ).root.also {
        binding = FragmentHomeAuthBinding.bind(it)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
    }

    private fun initListeners() {
        binding.btnSignInWithPassword.setOnClickListener {
            nextFragment(HomeAuthFragmentDirections.toLoginFragment())
        }
        binding.btnSignUpRegister.setOnClickListener {
            nextFragment(HomeAuthFragmentDirections.toRegisterFragment())
        }
    }
}