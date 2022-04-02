package com.example.movieapp20.detailscreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import com.example.movieapp20.ui.theme.getMovies

@Preview
@Composable
fun DetailScreen(
    navController: NavHostController = rememberNavController(),
    movieId: String? = "tt0499549"
) {
    MainContent {
        Text(text = "My detail screen $movieId")
    }
}

@Composable
fun MainContent(content: @Composable () -> Unit) {

    Scaffold(
        topBar = {
            TopAppBar(backgroundColor = Color.Cyan, elevation = 3.dp) {
                Row() {
                    Icon(imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Arrow back",
                        modifier = Modifier.clickable {

                        })
                    Spacer(modifier = Modifier.width(20.dp))

                    Text(text = "Movie X")
                }
            }

        }) {
        content()

    }
}


/*

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
//import com.example.movieapp.home.MainContent
import com.example.movieapp.ui.theme.getMovies


@Composable
fun DetailScreen(movieId: String? = getMovies()[0].id){
    Text(text = "My detail screen")
}

 */