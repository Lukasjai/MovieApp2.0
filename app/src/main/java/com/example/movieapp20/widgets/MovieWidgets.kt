package com.example.movieapp20.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.movieapp20.ui.theme.Movie
import com.example.movieapp20.ui.theme.getMovies


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MovieRow(
    movie: Movie = getMovies()[0],
    onItemClick: (String) -> Unit = {},
    isFavourite: Boolean,
    onFavouriteClick: (Movie) -> Unit
) {

    var changeState by remember {
        mutableStateOf(false)
    }
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .height(130.dp)
            .clickable {
                onItemClick(movie.id)
            },
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        elevation = 6.dp
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Surface(
                modifier = Modifier
                    .size(100.dp)
                    .padding(12.dp)
            ) {
                // Icon(imageVector = Icons.Default.AccountBox, contentDescription = "movie pic")
                AsyncImage(
                    model = movie.images[0],
                    contentDescription = "movie_pictures",
                    modifier = Modifier.clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
            }

            LazyColumn {
                item {
                    Text(text = movie.title)
                    Text(text = "Director: ${movie.director}")
                    Text(text = "Year: ${movie.year}")
                    AnimatedVisibility(visible = changeState) {
                        Column(modifier = Modifier.padding(8.dp)) {
                            Text(text = "Plot: ${movie.plot}")
                            Text(text = "Actors: ${movie.actors}")
                            Text(text = "Genre: ${movie.genre}")
                            Text(text = "Rating: ${movie.rating}")
                        }
                    }
                    IconButton(onClick = { changeState = !changeState }) {
                        if (changeState) {
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowUp,
                                contentDescription = "Arrowup"
                            )
                        } else {
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowDown,
                                contentDescription = "Arrowdown"
                            )
                        }
                    }

                }

            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalAlignment = Alignment.End,
            ) {

                favouriteButton(movie = movie, favouriteboolean = isFavourite){
                    movie -> onFavouriteClick(movie)
                }
            }

        }


    }
}


@Composable
fun favouriteButton(
    movie: Movie,
    favouriteboolean: Boolean,
    onFavouriteClick: (Movie) -> Unit = {}
) {
    IconButton(onClick = {
        onFavouriteClick(movie)
    }) {
        if (!favouriteboolean) {
            Icon(
                imageVector = Icons.Default.FavoriteBorder,
                contentDescription = "FavouriteBorder",
                tint = Color.Green
            )
        } else {
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = "FavouriteBorder",
                tint = Color.Green
            )

        }
    }


}






@Composable
fun HorizontalScrollableImageView(movie: Movie = getMovies()[0]){
    LazyRow{
        items(movie.images){ images ->

        Card(modifier = Modifier
            .padding(12.dp)
            .size(240.dp), elevation = 4.dp) {
                AsyncImage(model = images,
                    contentDescription = "movie image",)
            }
        }

        /*
        AsyncImage(model = movie.images[0],
            contentDescription = "movie_pictures",
            modifier = Modifier.clip(CircleShape),
            contentScale = ContentScale.Crop
        )

         */
        }
    }
