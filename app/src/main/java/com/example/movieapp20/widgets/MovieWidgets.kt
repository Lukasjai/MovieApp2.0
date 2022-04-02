package com.example.movieapp20.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.movieapp20.ui.theme.Movie
import com.example.movieapp20.ui.theme.getMovies


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MovieRow (movie: Movie = getMovies()[0]){
    var changeState by remember {
        mutableStateOf(false)
    }
    Card(modifier = Modifier
        .padding(4.dp)
        .fillMaxWidth()
        .height(130.dp),
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        elevation = 6.dp
    ) {
        Row (verticalAlignment = Alignment.CenterVertically){
            Surface(modifier = Modifier
                .size(100.dp)
                .padding(12.dp)) {
                Icon(imageVector = Icons.Default.AccountBox, contentDescription = "movie pic")
            }

            LazyColumn{
                item{
                    Text(text= movie.title)
                    Text(text = "Director: ${movie.director}")
                    Text(text = "Year: ${movie.year}")
                    AnimatedVisibility(visible = changeState ) {
                        Column(modifier = Modifier.padding(8.dp)) {
                            Text(text = "Plot: ${movie.plot}")
                            Text(text = "Actors: ${movie.actors}")
                            Text(text = "Genre: ${movie.genre}")
                            Text(text = "Rating: ${movie.rating}")
                        }
                    }
                    IconButton(onClick = {changeState =! changeState}) {
                        if (changeState){
                            Icon(imageVector = Icons.Default.KeyboardArrowUp, contentDescription = "Arrowup")
                        }else{
                            Icon(imageVector = Icons.Default.KeyboardArrowDown, contentDescription = "Arrowdown")
                        }
                    }
                }
            }
        }

    }
}
