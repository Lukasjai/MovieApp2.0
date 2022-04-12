package com.example.movieapp20.home


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.movieapp20.navigation.MovieScreen
import com.example.movieapp20.ui.theme.Movie
import com.example.movieapp20.ui.theme.getMovies
import com.example.movieapp20.viewModel.FavouriteViewModel
import com.example.movieapp20.widgets.MovieRow

@Composable
fun HomeScreen(navController: NavController = rememberNavController(), favouriteViewModel: FavouriteViewModel) {
    var showMenu by remember {
        mutableStateOf(false)
    }
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Movie") },
                actions = {
                    IconButton(onClick = { showMenu = !showMenu }) {
                        Icon(imageVector = Icons.Default.MoreVert, contentDescription = "moreVert")
                    }
                    DropdownMenu(expanded = showMenu, onDismissRequest = { showMenu = false }) {
                        DropdownMenuItem(onClick = { /*TODO*/ }) {
                            Row {
                                Icon(
                                    imageVector = Icons.Default.Favorite,
                                    contentDescription = "Favorites"
                                )
                                Text(
                                    text = "Favorites", modifier = Modifier
                                        .padding(4.dp)
                                        .width(100.dp)
                                        .clickable {
                                            navController.navigate(MovieScreen.FavouriteScreen.name)
                                        }
                                )
                            }
                        }

                    }
                })
        }) {
        MainContent(navController = navController, isFavoriteLambda = {movie -> favouriteViewModel.movieIsFavourite(movie)}){
            movie -> if (favouriteViewModel.movieIsFavourite(movie)){
                favouriteViewModel.removeMovie(movie)
        }else{
            favouriteViewModel.addMovie(movie = movie)
        }
        }
    }


}

@Composable
fun MainContent(
    navController: NavController,
    movieList: List<Movie> = getMovies(),
    isFavoriteLambda: (Movie) -> Boolean,
    onFavoriteClick: (Movie) -> Unit = {}
) {
    LazyColumn {
        items(movieList) { movie ->
            MovieRow(
                movie = movie,
                isFavourite = isFavoriteLambda(movie),
                onFavouriteClick = onFavoriteClick,
                onItemClick = { movieId ->
                    navController.navigate("homeScreen")
                    navController.navigate(MovieScreen.DetailScreen.name + "/$movieId")
                })
            //  ActualMovies(movie = movie)
        }
    }
}






