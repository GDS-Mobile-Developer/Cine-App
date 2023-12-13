package com.gdsdevtec.cineapp.presenter.main.bottombar.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.gdsdevtec.cineapp.databinding.FragmentHomeBinding
import com.gdsdevtec.cineapp.presenter.main.bottombar.home.adapter.GenreMovieAdapter
import com.gdsdevtec.cineapp.presenter.model.GenrePresentation
import com.gdsdevtec.cineapp.utils.StateView
import com.gdsdevtec.cineapp.utils.messageToast
import com.gdsdevtec.cineapp.utils.nextFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val viewModel by viewModels<HomeViewModel>()
    private lateinit var genreMovieAdapter: GenreMovieAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ) = FragmentHomeBinding.inflate(
        inflater, container, false
    ).root.also {
        binding = FragmentHomeBinding.bind(it)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
        getGenres()
    }

    private fun getGenres() {
        viewModel.getGenres().observe(viewLifecycleOwner) { stateView ->
            when (stateView) {
                is StateView.Loading -> {
                    messageToast("Loading")
                }

                is StateView.Success -> {
                    genreMovieAdapter.submitList(stateView.data)
                    getMoviesByGenres(stateView.data)
                    messageToast("Deu BOm ")
                }

                is StateView.Error -> {
                    messageToast("deu merda")
                }
            }
        }
    }

    private fun getMoviesByGenres(genres: List<GenrePresentation>) {
        val genreMutableList = genres.toMutableList()
        genreMutableList.forEachIndexed { index, genrePresentation ->
            viewModel.getMoviesByGenreId(genrePresentation.id).observe(viewLifecycleOwner) { stateView ->
                when (stateView) {
                    is StateView.Loading -> {
                    }
                    is StateView.Success -> {
                        genreMutableList[index] = genrePresentation.copy(
                            movies = stateView.data.take(5)
                        )
                        genreMovieAdapter.submitList(genreMutableList)
                        messageToast("Deu BOm ")
                    }

                    is StateView.Error -> {
                        messageToast("deu merda")
                    }
                }
            }
        }
    }

    private fun initRecycler() {
        genreMovieAdapter = GenreMovieAdapter{
            nextFragment(HomeFragmentDirections.toMovieGenreFragment(it))
        }
        with(binding.rvGenreMovies) {
            setHasFixedSize(true)
            adapter = genreMovieAdapter
        }
    }

}