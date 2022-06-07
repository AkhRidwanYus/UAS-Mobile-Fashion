package com.helehpro.ghibli.ui.location

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.ListAdapter
import com.helehpro.ghibli.network.Location
import com.helehpro.ghibli.databinding.ListViewItemBinding

class LocationListAdapter(private val clickListener: LocationListener) :
    ListAdapter<Location, LocationListAdapter.LocationViewHolder>(DiffCallback)
{
    class LocationViewHolder(
        var binding: ListViewItemBinding
    ) : RecyclerView.ViewHolder(binding.root){
        fun bind(clickListener: LocationListener, location: Location){
            binding.location = location
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Location>(){
        override fun areItemsTheSame(oldItem: Location, newItem: Location): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Location, newItem: Location): Boolean {
            return oldItem.terrain == newItem.terrain && oldItem.climate == newItem.climate
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : LocationViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return LocationViewHolder(
            ListViewItemBinding.inflate(layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int){
        val location = getItem(position)
        holder.bind(clickListener, location)
    }

}

class LocationListener(val clickListener: (location: Location ) -> Unit){
    fun onClick(location: Location ) = clickListener(location)
}
