package com.gdsdevtec.cineapp.presenter.auth.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.gdsdevtec.cineapp.R
import com.gdsdevtec.cineapp.databinding.FragmentLoginBinding
import com.gdsdevtec.cineapp.utils.StateView
import com.gdsdevtec.cineapp.utils.messageToast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private val viewModel: LoginViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ) = FragmentLoginBinding.inflate(
        inflater, container, false
    ).root.also {
        binding = FragmentLoginBinding.bind(it)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
    }

    private fun initListeners() {
        binding.btnSignInLogin.setOnClickListener {
            validateData()
        }
        Glide
            .with(requireContext())
            .load(R.drawable.loading)
            .into(binding.progressLoading)
    }

    private fun validateData() {
        val email = binding.editEmail.text.toString().trim()
        val password = binding.editPassword.text.toString().trim()
        if (email.isNotBlank()) {
            if (password.isNotBlank()) {
                loginUser(email, password)
            } else {
                messageToast("vazio")
            }
        } else {
            messageToast("vazio")
        }
    }

    private fun loginUser(email: String, password: String) {
        viewModel.login(email, password).observe(viewLifecycleOwner) { stateView ->
            when (stateView) {
                is StateView.Loading -> {
                    binding.progressLoading.isVisible = true
                }

                is StateView.Success -> {
                    messageToast("success")
                }
                is StateView.Error -> {
                    binding.progressLoading.isVisible = false
                    messageToast(stateView.msg)
                }
            }
        }
    }

}