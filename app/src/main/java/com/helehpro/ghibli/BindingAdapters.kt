package com.helehpro.ghibli

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.helehpro.ghibli.network.Film
import com.helehpro.ghibli.network.Location
import com.helehpro.ghibli.network.Species
import com.helehpro.ghibli.ui.film.FilmApiStatus
import com.helehpro.ghibli.ui.film.FilmListAdapter
import com.helehpro.ghibli.ui.location.LocationApiStatus
import com.helehpro.ghibli.ui.location.LocationListAdapter
import com.helehpro.ghibli.ui.species.SpeciesApiStatus
import com.helehpro.ghibli.ui.species.SpeciesListAdapter


@BindingAdapter("listFilmData")
fun bindFilmRecyclerView(recyclerView: RecyclerView, data: List<Film>?) {
    val adapter = recyclerView.adapter as FilmListAdapter
    adapter.submitList(data)
}

@BindingAdapter("listSpeciesData")
fun bindSpeciesRecyclerView(recyclerView: RecyclerView, data: List<Species>?) {
    val adapter = recyclerView.adapter as SpeciesListAdapter
    adapter.submitList(data)
}

@BindingAdapter("listLocationData")
fun bindLocationRecyclerView(recyclerView: RecyclerView, data: List<Location>?) {
    val adapter = recyclerView.adapter as LocationListAdapter
    adapter.submitList(data)
}


@BindingAdapter("apiFilmStatus")
fun bindFilmStatus(statusImageView: ImageView, status: FilmApiStatus?) {
    when(status){
        FilmApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        FilmApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
        else -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
    }
}

@BindingAdapter("apiSpeciesStatus")
fun bindSpeciesStatus(statusImageView: ImageView, status: SpeciesApiStatus?) {
    when(status){
        SpeciesApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        SpeciesApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
        else -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
    }
}

@BindingAdapter("apiLocationStatus")
fun bindLocationStatus(statusImageView: ImageView, status: LocationApiStatus?) {
    when(status){
        LocationApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        LocationApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
        else -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
    }
}

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, image: String?) {
    image?.let {
        val imgUri = image.toUri().buildUpon().scheme("https").build()
        Glide.with(imgView.context)
            .load(imgUri)
            .into(imgView)
    }
}