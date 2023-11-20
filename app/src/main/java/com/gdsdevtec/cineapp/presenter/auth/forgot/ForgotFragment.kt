package com.gdsdevtec.cineapp.presenter.auth.forgot

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gdsdevtec.cineapp.databinding.FragmentForgotBinding

class ForgotFragment : Fragment() {
    private lateinit var binding : FragmentForgotBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ) = FragmentForgotBinding.inflate(
        inflater,container, false
    ).root.also {
        binding = FragmentForgotBinding.bind(it)
    }

}