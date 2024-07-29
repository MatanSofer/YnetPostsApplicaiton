package com.example.ynetpostsapplication.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.ynetpostsapplication.presentation.navigation.MainNavgraph
import com.example.ynetpostsapplication.presentation.theme.YnetPostsApplicationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            YnetPostsApplicationTheme {
                val navController = rememberNavController()
                MainNavgraph(navController = navController)
            }
        }
    }
}
