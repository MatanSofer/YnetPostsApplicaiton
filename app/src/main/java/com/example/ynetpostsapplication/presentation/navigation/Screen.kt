package com.example.ynetpostsapplication.presentation.navigation

sealed class Screen(val route: String) {
    object OpenScreen: Screen("open_screen")
    object ListsScreen: Screen("lists_screen")
}