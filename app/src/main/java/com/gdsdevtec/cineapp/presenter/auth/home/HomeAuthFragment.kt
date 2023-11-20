package com.gdsdevtec.cineapp.presenter.auth.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gdsdevtec.cineapp.databinding.FragmentHomeAuthBinding

class HomeAuthFragment : Fragment() {
    private lateinit var binding: FragmentHomeAuthBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ) = FragmentHomeAuthBinding.inflate(
        inflater,container,false
    ).root.also {
        binding = FragmentHomeAuthBinding.bind(it)
    }

}