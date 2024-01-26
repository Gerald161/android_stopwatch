package com.example.stopwatch.Navigation

import android.os.Build
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.stopwatch.Navigation.Screens.HomeScreen
import com.example.stopwatch.service.StopWatchService


@Composable
fun Navigation(
    navController: NavHostController,
    stopWatchService: StopWatchService
){
    NavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route
    ){
        composable(route = Screen.HomeScreen.route){
            HomeScreen(navController, stopWatchService)
        }
    }
}