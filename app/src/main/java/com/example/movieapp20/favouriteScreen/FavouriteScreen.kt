package com.example.movieapp20.favouriteScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.movieapp20.detailscreen.filterMovie
import com.example.movieapp20.navigation.MovieScreen
import com.example.movieapp20.ui.theme.Movie
import com.example.movieapp20.widgets.MovieRow
import com.example.movieapp20.viewModel.FavouriteViewModel

@Composable
fun FavouriteScreen(
    navController: NavHostController = rememberNavController(),
    favouriteViewModel: FavouriteViewModel
) {
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
        val favourites = favouriteViewModel.favouriteMovie
        Column {
            MainContent(favorites = favourites, navController = navController)
        }
    }
}


@Composable
fun MainContent(favorites: List<Movie>, navController: NavHostController) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        LazyColumn {
            items(favorites) { movie ->
                MovieRow(movie = movie, showFavIcon = false, isItFavourite = false, onItemClick = {
                    navController.navigate(route = MovieScreen.DetailScreen.name + "/${movie.id}")
                }) {
                }
                Spacer(modifier = Modifier.height(8.dp))
                Divider()
            }
        }
    }
}
