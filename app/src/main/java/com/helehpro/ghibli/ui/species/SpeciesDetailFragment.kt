package com.helehpro.ghibli.ui.species

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.helehpro.ghibli.databinding.FragmentFilmDetailBinding
import com.helehpro.ghibli.databinding.FragmentSpeciesDetailBinding


class SpeciesDetailFragment : Fragment() {
    private val viewModel: SpeciesViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSpeciesDetailBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        return binding.root

    }
}