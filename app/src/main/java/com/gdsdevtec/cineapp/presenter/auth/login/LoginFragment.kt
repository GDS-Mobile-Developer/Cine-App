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
import com.gdsdevtec.cineapp.utils.hideKeyboard
import com.gdsdevtec.cineapp.utils.initToolbar
import com.gdsdevtec.cineapp.utils.isEmailValid
import com.gdsdevtec.cineapp.utils.isPasswordValid
import com.gdsdevtec.cineapp.utils.messageToast
import com.gdsdevtec.cineapp.utils.nextFragment
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
        initToolbar(binding.toolbar)
        initListeners()
    }

    private fun initListeners() {
        binding.btnSignInLogin.setOnClickListener {
            validateData()
        }
        binding.btnResetPassword.setOnClickListener {
            nextFragment(LoginFragmentDirections.toForgotFragment())
        }
        binding.btnSignUpRegister.setOnClickListener {
            nextFragment(LoginFragmentDirections.toRegisterFragment())
        }
        Glide
            .with(requireContext())
            .load(R.drawable.loading)
            .into(binding.progressLoading)
    }

    private fun validateData() {
        validateEmail(
            email = binding.editEmail.text.toString().trim(),
            password = binding.editPassword.text.toString().trim()
        )
    }

    private fun validateEmail(email: String, password: String) {
        if (email.isEmailValid()) {
            validatePassword(password, email)
        } else emailInvalid()
    }

    private fun validatePassword(password: String, email: String) {
        if (password.isPasswordValid()) {
            loginUser(email, password)
        } else passwordInvalid()
    }

    private fun passwordInvalid() = binding.editPassword.apply {
        error = "Senha invalida"
        requestFocus()
    }

    private fun emailInvalid() = binding.editEmail.apply {
        error = "Email invalido"
        requestFocus()
    }

    private fun loginUser(email: String, password: String) {
        hideKeyboard()
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