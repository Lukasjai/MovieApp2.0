package com.example.movieapp20.detailscreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.movieapp20.ui.theme.Movie
import com.example.movieapp20.ui.theme.getMovies
import com.example.movieapp20.viewModel.FavouriteViewModel
import com.example.movieapp20.widgets.HorizontalScrollableImageView
import com.example.movieapp20.widgets.MovieRow


@Composable
fun DetailScreen(
    navController: NavHostController = rememberNavController(),
    movieId: String? = "tt0499549",
    favouriteViewModel: FavouriteViewModel
) {
    val movie = filterMovie(movieId = movieId)

    Scaffold(
        topBar = {
            TopAppBar(backgroundColor = Color.Cyan, elevation = 3.dp) {
                Row {
                    Icon(imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Arrow back",
                        modifier = Modifier.clickable {
                            navController.popBackStack()  // go back to the last destination(screen)
                        })

                    Spacer(modifier = Modifier.width(20.dp))

                    Text(text = movie.title)
                }
            }

        }) {
        MainContent(
            movie = movie,
            favouritelambda = { movie -> favouriteViewModel.movieIsFavourite(movie)}){
                movie -> if (favouriteViewModel.movieIsFavourite(movie)){
            favouriteViewModel.removeMovie(movie)
        }else{
            favouriteViewModel.addMovie(movie = movie)
        }
        }
    }
}


@Composable
fun MainContent(movie: Movie,favouritelambda: (Movie) -> Boolean, onFavouriteClick: (Movie) -> Unit = {}) {
    Surface(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
        Column {
            MovieRow(movie = movie, isFavourite = favouritelambda(movie), onFavouriteClick = onFavouriteClick)

            Spacer(modifier = Modifier.height(8.dp))

            Divider()

            HorizontalScrollableImageView(movie = movie)
        }
    }
   // Text(text = "${movie.title}", style = MaterialTheme.typography.h5)
}


fun filterMovie(movieId: String?): Movie {
    return getMovies().filter { movie ->  movie.id == movieId }[0]
}