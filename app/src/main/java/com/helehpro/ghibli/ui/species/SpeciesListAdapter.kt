package com.helehpro.ghibli.ui.species

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.helehpro.ghibli.databinding.FilmsBinding
import com.helehpro.ghibli.databinding.SpeciesesBinding
import com.helehpro.ghibli.network.Film
import com.helehpro.ghibli.network.Species


class SpeciesListAdapter(val clickListener: SpeciesListener) :
    ListAdapter<Species, SpeciesListAdapter.SpeciesViewHolder>(DiffCallback) {

    class SpeciesViewHolder(var binding: SpeciesesBinding):
        RecyclerView.ViewHolder(binding.root){
        fun bind(clickListener: SpeciesListener, species: Species){
            binding.species = species
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Species>() {

        override fun areItemsTheSame(oldItem: Species, newItem: Species): Boolean{
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Species, newItem: Species): Boolean {
            return oldItem.clasification == newItem.clasification
        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpeciesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return SpeciesViewHolder(
            SpeciesesBinding.inflate(layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: SpeciesViewHolder, position: Int) {
        val ghibli = getItem(position)
        holder.bind(clickListener, ghibli)
    }
}

class SpeciesListener(val clickListener: (ghibi: Species) -> Unit) {
    fun onClick(ghibi: Species) = clickListener(ghibi)
}
