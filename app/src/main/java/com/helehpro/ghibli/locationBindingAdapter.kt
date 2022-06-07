package com.helehpro.ghibli

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.helehpro.ghibli.network.Location
import com.helehpro.ghibli.ui.location.LocationApiStatus
import com.helehpro.ghibli.ui.location.LocationListAdapter


@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Location>?){
    val adapter = recyclerView.adapter as LocationListAdapter
    adapter.submitList(data)
}

@BindingAdapter("apiStatus")
fun bindStatus(statusImageView: ImageView, status: LocationApiStatus?) {
    when(status) {
        LocationApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        LocationApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
        LocationApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
        else -> {}
    }
}
