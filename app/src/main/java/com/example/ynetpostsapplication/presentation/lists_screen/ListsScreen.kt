package com.example.ynetpostsapplication.presentation.lists_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.ynetpostsapplication.presentation.lists_screen.composable.ListItem

@Composable
fun ListsScreen(
    viewModel: ListScreenViewModel = hiltViewModel()
){
    val state  = viewModel.state.collectAsState().value
    Box(modifier = Modifier.fillMaxSize()){
        LazyColumn(modifier = Modifier.fillMaxSize() ){
            items(state.cars.size){
                    car ->
                ListItem(
                    title = "car title",
//                    onItemClick ={viewModel.onAction(ListScreenUiAction.NavigateBackWithTitle(car.title))}
                    onItemClick = {}
                )
            }
        }
        if(state.secondTabIsLoading){
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}
@Preview
@Composable
private fun ListsScreenPreview(){
    ListsScreen(

    )
}
