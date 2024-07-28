package com.example.ynetpostsapplication.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.ynetpostsapplication.presentation.lists_screen.ListsScreen
import com.example.ynetpostsapplication.presentation.open_screen.OpenScreen

@Composable
fun MainNavgraph(
    navController: NavHostController,
){
    NavHost(
        navController = navController,
        startDestination = Screen.OpenScreen.route
    ) {
        composable(
            route = Screen.OpenScreen.route
        ){ entry ->
            val lastClickedTitle = entry.savedStateHandle.get<String>("clicked_title")
            OpenScreen(navController,lastClickedTitle)
        }
        composable(
            route = Screen.ListsScreen.route
        ){
            ListsScreen(navController)
        }
    }
}