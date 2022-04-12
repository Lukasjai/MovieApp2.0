package com.example.movieapp20

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview

import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.movieapp20.home.HomeScreen
import com.example.movieapp20.navigation.MovieNavigation
import com.example.movieapp20.ui.theme.MovieApp20Theme
import com.example.movieapp20.ui.theme.getMovies
import com.example.movieapp20.viewModel.FavouriteViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val movies = getMovies()
        val favouriteModel: FavouriteViewModel by viewModels()
        val favs = favouriteModel.favouriteMovie
        setContent {
            Myapp {
                MovieNavigation()
            }
        }
    }
}


@Composable
fun Myapp(content: @Composable () -> Unit) {
    MovieApp20Theme {
        content()
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Myapp {
        MovieNavigation()
    }
}
