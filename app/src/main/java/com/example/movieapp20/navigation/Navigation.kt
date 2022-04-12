package com.example.movieapp20.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.movieapp20.detailscreen.DetailScreen
import com.example.movieapp20.favouriteScreen.FavouriteScreen
import com.example.movieapp20.home.HomeScreen
import com.example.movieapp20.viewModel.FavouriteViewModel




@Composable
fun MovieNavigation() {
    val navController = rememberNavController()
    val favouritesViewModel: FavouriteViewModel = viewModel()


    NavHost(navController = navController, startDestination = MovieScreen.HomeScreen.name) {
        composable(route = MovieScreen.HomeScreen.name) {
            HomeScreen(
                navController = navController,
                favouritesViewModel
            )
        }
        composable(MovieScreen.FavouriteScreen.name) {
            FavouriteScreen(
                navController = navController,
            favouriteViewModel = favouritesViewModel
            )
        }
        composable(
            route = MovieScreen.DetailScreen.name + "/{movie}",
            arguments = listOf(navArgument("movie") { type = NavType.StringType })
        ) { backstackEntry ->
            DetailScreen(
                navController = navController,
                movieId = backstackEntry.arguments?.getString("movie"),
                favouritesViewModel
            )
        }

    }
}





/*

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.movieapp.DetailScreen.DetailScreen
import com.example.movieapp.home.HomeScreen

@Composable
fun MovieNavigation ( ){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "homeScreen" ){
        composable("homeScreen"){ HomeScreen(navController = navController)}
        composable(route ="detailScreen/{movieId}",
            arguments = listOf(navArgument("movieId"){
                type = NavType.StringType
            })
        ){
            DetailScreen()
        }


        route = "detailScreen/{movieId}",
        arguments = listOf(navArgument("movieId"){
            type = NavType.StringType
        })
        ){ backStackEntry ->
        DetailScreen(movieId = BackStackEntry.arguments?.getString("movieId"))
    }



        //add more routes and screens here
    }
}


 */
