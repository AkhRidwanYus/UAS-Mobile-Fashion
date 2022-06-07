package com.helehpro.ghibli.ui.location

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.helehpro.ghibli.network.Location
import com.helehpro.ghibli.network.GhibliApi
import kotlinx.coroutines.launch
import java.lang.Exception

enum class LocationApiStatus { LOADING, ERROR, DONE }

class LocationViewModel : ViewModel() {
    private val _status = MutableLiveData<LocationApiStatus>()
    val status: LiveData<LocationApiStatus> = _status

    private val _location= MutableLiveData<List<Location>>()
    val location: LiveData<List<Location>> = _location

    private val _places = MutableLiveData<Location>()
    val places: LiveData<Location> = _places

    fun getLocationList() {
        viewModelScope.launch {
            _status.value = LocationApiStatus.LOADING
            try {
                _location.value = GhibliApi.retrofitService.getLocation()
                _status.value = LocationApiStatus.DONE
            } catch (e: Exception) {
                e.printStackTrace()
                _status.value = LocationApiStatus.ERROR
            }
        }
    }

    fun onLocationClicked(location: Location) {
        _places.value = location
    }
}