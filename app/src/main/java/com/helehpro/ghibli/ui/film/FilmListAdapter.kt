package com.helehpro.ghibli.ui.film

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.helehpro.ghibli.databinding.FilmsBinding
import com.helehpro.ghibli.network.Film


class FilmListAdapter(val clickListener: FilmListener) :
    ListAdapter<Film, FilmListAdapter.FilmViewHolder>(DiffCallback) {

    class FilmViewHolder(var binding: FilmsBinding):
        RecyclerView.ViewHolder(binding.root){
        fun bind(clickListener: FilmListener, film: Film){
            binding.film = film
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Film>() {

        override fun areItemsTheSame(oldItem: Film, newItem: Film): Boolean{
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: Film, newItem: Film): Boolean {
            return oldItem.description == newItem.description
        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return FilmViewHolder(
            FilmsBinding.inflate(layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        val film = getItem(position)
        holder.bind(clickListener, film)
    }
}

class FilmListener(val clickListener: (film: Film) -> Unit) {
    fun onClick(film: Film) = clickListener(film)
}
