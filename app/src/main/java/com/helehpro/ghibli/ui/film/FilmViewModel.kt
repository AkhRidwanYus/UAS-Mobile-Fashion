package com.helehpro.ghibli.ui.film

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.helehpro.ghibli.network.Film
import com.helehpro.ghibli.network.GhibliApi
import kotlinx.coroutines.launch

enum class FilmApiStatus {LOADING, ERROR, DONE}

class FilmViewModel: ViewModel() {
    private val _status = MutableLiveData<FilmApiStatus>()
    val status : LiveData<FilmApiStatus> = _status

    private val _films = MutableLiveData<List<Film>>()
    val films : LiveData<List<Film>> = _films

    private val _film = MutableLiveData<Film>()
    val film : LiveData<Film> = _film

    fun getFilmList(){
        _status.value = FilmApiStatus.LOADING
        viewModelScope.launch {
            try {
                _films.value = GhibliApi.retrofitService.getFilm()
                _status.value = FilmApiStatus.DONE
            }catch (e: Exception){
                e.printStackTrace()
                _status.value = FilmApiStatus.ERROR
            }

        }

    }

    fun onFilmCliked(Film: Film){
        _film.value = Film
    }
}

