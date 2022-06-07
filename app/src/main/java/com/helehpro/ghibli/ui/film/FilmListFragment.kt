package com.helehpro.ghibli.ui.film

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.helehpro.ghibli.R
import com.helehpro.ghibli.databinding.FragmentFilmListBinding

class FilmListFragment: Fragment() {

   private val viewModel: FilmViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceSate: Bundle?
    ): View? {
        val binding = FragmentFilmListBinding.inflate(inflater)
        viewModel.getFilmList()
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.recyclerView.adapter = FilmListAdapter(FilmListener{
            film -> viewModel.onFilmCliked(film)
            findNavController()
                .navigate(R.id.action_filmListFragment_to_filmDetailFragment)
        })
        return binding.root
    }
}