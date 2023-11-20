package com.gdsdevtec.cineapp.presenter.auth.forgot

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.gdsdevtec.cineapp.R
import com.gdsdevtec.cineapp.databinding.FragmentForgotBinding
import com.gdsdevtec.cineapp.utils.FirebaseHelper
import com.gdsdevtec.cineapp.utils.StateView
import com.gdsdevtec.cineapp.utils.hideKeyboard
import com.gdsdevtec.cineapp.utils.initToolbar
import com.gdsdevtec.cineapp.utils.isEmailValid
import com.gdsdevtec.cineapp.utils.messageToast
import com.gdsdevtec.cineapp.utils.showSnackBar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ForgotFragment : Fragment() {
    private lateinit var binding: FragmentForgotBinding
    private val viewModel: ForgotViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ) = FragmentForgotBinding.inflate(
        inflater, container, false
    ).root.also {
        binding = FragmentForgotBinding.bind(it)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
        initToolbar(binding.toolbar2)
    }

    private fun initListeners() {
        binding.btnForgot.setOnClickListener {
            validateData()
        }
        Glide
            .with(requireContext())
            .load(R.drawable.loading)
            .into(binding.progressLoading)
    }

    private fun validateData() {
        validateEmail(
            email = binding.editEmail.text.toString().trim()
        )
    }

    private fun validateEmail(email: String) {
        if (email.isEmailValid()) {
            forgotPassword(email)
        } else emailInvalid()
    }

    private fun emailInvalid() = binding.editEmail.apply {
        error = "Email invalido"
        requestFocus()
    }

    private fun forgotPassword(password: String) {
        hideKeyboard()
        viewModel.forgotPassword(password).observe(viewLifecycleOwner) { stateView ->
            when (stateView) {
                is StateView.Loading -> binding.progressLoading.isVisible = true
                is StateView.Success -> {
                    messageToast("success")
                }

                is StateView.Error -> {
                    binding.progressLoading.isVisible = false
                    showSnackBar(msg = FirebaseHelper.validError(stateView.msg))
                }
            }
        }
    }


}