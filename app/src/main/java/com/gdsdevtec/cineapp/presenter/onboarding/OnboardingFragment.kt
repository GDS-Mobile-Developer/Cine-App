package com.gdsdevtec.cineapp.presenter.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gdsdevtec.cineapp.databinding.FragmentOnboardingBinding
import com.gdsdevtec.cineapp.utils.nextFragment

class OnboardingFragment : Fragment() {
    private lateinit var binding: FragmentOnboardingBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ) = FragmentOnboardingBinding.inflate(
        inflater, container, false
    ).root.also {
        binding = FragmentOnboardingBinding.bind(it)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
    }

    private fun initListeners() {
        binding.btnGetStarted.setOnClickListener {
            nextFragment(OnboardingFragmentDirections.toHomeAuthFragment())
        }
    }
}