package com.helehpro.ghibli.ui.species

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.helehpro.ghibli.network.Film
import com.helehpro.ghibli.network.GhibliApi
import com.helehpro.ghibli.network.Species
import kotlinx.coroutines.launch

enum class SpeciesApiStatus {LOADING, ERROR, DONE}

class SpeciesViewModel: ViewModel() {
    private val _status = MutableLiveData<SpeciesApiStatus>()
    val status : LiveData<SpeciesApiStatus> = _status

    private val _specieses = MutableLiveData<List<Species>>()
    val specieses : LiveData<List<Species>> = _specieses

    private val _species = MutableLiveData<Species>()
    val species : LiveData<Species> = _species

    fun getSpeciesList(){
        _status.value = SpeciesApiStatus.LOADING
        viewModelScope.launch {
            try {
                _specieses.value = GhibliApi.retrofitService.getSpecies()
                _status.value = SpeciesApiStatus.DONE
            }catch (e: Exception){
                e.printStackTrace()
                _status.value = SpeciesApiStatus.ERROR
            }

        }

    }

    fun onSpeciesCliked(Species: Species){
        _species.value = Species
    }
}

