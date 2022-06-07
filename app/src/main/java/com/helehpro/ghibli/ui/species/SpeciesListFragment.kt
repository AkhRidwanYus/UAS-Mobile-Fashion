package com.helehpro.ghibli.ui.species

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.helehpro.ghibli.R
import com.helehpro.ghibli.databinding.FragmentFilmListBinding
import com.helehpro.ghibli.databinding.FragmentSpeciesListBinding

class SpeciesListFragment: Fragment() {

   private val viewModel: SpeciesViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceSate: Bundle?
    ): View? {
        val binding = FragmentSpeciesListBinding.inflate(inflater)
        viewModel.getSpeciesList()
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.recyclerView.adapter = SpeciesListAdapter(SpeciesListener{
            film -> viewModel.onSpeciesCliked(film)
            findNavController()
                .navigate(R.id.action_filmListFragment_to_filmDetailFragment)
        })
        return binding.root
    }
}