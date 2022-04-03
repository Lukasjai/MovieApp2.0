package com.example.movieapp20.favouriteScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.movieapp20.detailscreen.filterMovie
import com.example.movieapp20.navigation.MovieScreen
import com.example.movieapp20.ui.theme.Movie
import com.example.movieapp20.ui.theme.getMovies
import com.example.movieapp20.widgets.HorizontalScrollableImageView
import com.example.movieapp20.widgets.MovieRow

@Composable
fun FavouriteScreen(
    navController: NavController = rememberNavController(),
    movieId: String? = "tt0993846",
) {
    val movie = filterMovie(movieId = movieId)

    var showMenu by remember {
        mutableStateOf(false)
    }
    Scaffold(
        topBar = {
            TopAppBar(backgroundColor = Color.DarkGray, elevation = 10.dp) {
                Row {
                    Icon(imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Arrow back",
                        modifier = Modifier.clickable {
                            navController.popBackStack()  // go back to the last destination(screen)
                        })

                    Spacer(modifier = Modifier.width(20.dp))

                    Text(text = "Favourite Movies")
                }
            }

        }) {
        Column() {
            MainContent(movie = movie)
        }


    }
}


@Composable
fun MainContent(movie: Movie) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Column {
            MovieRow(movie = movie)

            Spacer(modifier = Modifier.height(8.dp))

            Divider()

        }
    }
}
// Text(text = "${movie.title}", style = Material