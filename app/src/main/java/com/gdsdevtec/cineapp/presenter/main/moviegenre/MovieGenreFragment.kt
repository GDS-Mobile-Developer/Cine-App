package com.gdsdevtec.cineapp.presenter.main.moviegenre

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.gdsdevtec.cineapp.databinding.FragmentMovieGenreBinding
import com.gdsdevtec.cineapp.utils.initToolbar
import com.gdsdevtec.cineapp.utils.messageToast

class MovieGenreFragment : Fragment() {
    private lateinit var binding: FragmentMovieGenreBinding
    private val viewModel by viewModels<MovieGenreViewModel>()
    private val args by navArgs<MovieGenreFragmentArgs>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ) = FragmentMovieGenreBinding.inflate(
        inflater, container, false
    ).root.also {
        binding = FragmentMovieGenreBinding.bind(it)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar(binding.toolbar)
        messageToast("${args.genreId}")
    }
}