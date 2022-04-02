package com.example.movieapp20.detailscreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.movieapp20.ui.theme.Movie
import com.example.movieapp20.ui.theme.getMovies
import com.example.movieapp20.widgets.MovieRow

@Preview
@Composable
fun DetailScreen(
    navController: NavHostController = rememberNavController(),
    movieId: String? = "tt0499549"
) {
    val movie = filterMovie(movieId = movieId)
    MainContent(movie.title, navController = navController) {
        MovieRow(movie = movie)

        Spacer(modifier = Modifier.height(8.dp))

        Divider()

        Text(text = "${movie.title}", style = MaterialTheme.typography.h5)

    }
}


@Composable
fun MainContent(movieTitel: String,navController: NavHostController,  content: @Composable () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(backgroundColor = Color.Cyan, elevation = 3.dp) {
                Row() {
                    Icon(imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Arrow back",
                        modifier = Modifier.clickable {
                            navController.popBackStack()  // go back to the last destination(screen)
                        })
                    Spacer(modifier = Modifier.width(20.dp))

                    Text(text = movieTitel)
                }
            }

        }) {
        content()

    }
}


fun filterMovie(movieId: String?): Movie {
    return getMovies().filter { movie ->  movie.id == movieId }[0]
}