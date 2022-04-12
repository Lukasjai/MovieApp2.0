package com.example.movieapp20.viewModel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.movieapp20.ui.theme.Movie

class FavouriteViewModel : ViewModel() {

    private val _favouriteMovie = mutableStateListOf<Movie>()
    val favouriteMovie: List<Movie>
        get() = _favouriteMovie

    fun addMovie(movie: Movie) {
        if (favouriteMovie.contains(movie)) {
        } else {
            _favouriteMovie.add(movie)

        }
    }

    fun removeMovie(movie: Movie) {
        _favouriteMovie.remove(movie)
    }

    fun movieIsFavourite(movie: Movie): Boolean {
        return _favouriteMovie.contains(movie)
    }

}