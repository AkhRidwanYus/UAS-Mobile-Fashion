package com.helehpro.ghibli.ui.location

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager

import com.google.android.material.snackbar.Snackbar
import com.helehpro.ghibli.R
import com.helehpro.ghibli.databinding.FragmentLocationListBinding

class LocationListFragment : Fragment(){
    private val viewModel: LocationViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentLocationListBinding.inflate(inflater)
        viewModel.getLocationList()
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.recyclerView.adapter = LocationListAdapter(LocationListener { pants ->
            viewModel.onLocationClicked(pants)
            findNavController()
                .navigate(R.id.action_locationListFragment_to_locationDetailFragment)
        })

        return binding.root
    }
}