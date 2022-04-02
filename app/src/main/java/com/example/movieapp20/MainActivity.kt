package com.example.movieapp20

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MoreVert

import androidx.compose.material.icons.filled.*
import androidx.navigation.Navigation
import androidx.navigation.compose.rememberNavController
import com.example.movieapp20.home.HomeScreen
import com.example.movieapp20.navigation.MovieNavigation
import com.example.movieapp20.ui.theme.Movie
import com.example.movieapp20.ui.theme.MovieApp20Theme
import com.example.movieapp20.ui.theme.getMovies


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
    MovieApp20Theme{
            HomeScreen()
        }
    }
