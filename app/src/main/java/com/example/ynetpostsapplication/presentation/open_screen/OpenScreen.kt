package com.example.ynetpostsapplication.presentation.open_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.ynetpostsapplication.R
import com.example.ynetpostsapplication.presentation.navigation.Screen
import com.example.ynetpostsapplication.presentation.open_screen.model.OpenScreenViewModel


@Composable
fun OpenScreen(
    navController: NavController,
    label: String? = null,
    viewModel: OpenScreenViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsState().value
    val timeState = viewModel.getTimeInfoFlow().collectAsState().value

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.align(Alignment.TopCenter),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .height(96.dp)
                    .width(96.dp),
                painter = painterResource(R.drawable.ic_app_logo),
                contentDescription = null
            )
            Text(
                text = state.name,
                fontWeight = FontWeight.Bold,
                fontSize = 40.sp
            )
            Text(
                text = timeState,
                fontSize = 24.sp
            )
            if(!label.isNullOrEmpty()){
                Text(
                    text = stringResource(R.string.last_opened_article),
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Blue
                )
            }
            Text(
                text = if(!label.isNullOrEmpty()) label else stringResource(R.string.no_valid_article),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = if(!label.isNullOrEmpty()) Color.DarkGray else Color.Red,
                modifier = Modifier.fillMaxWidth()
            )
        }

        Button(
            onClick = { navController.navigate(Screen.ListsScreen.route) },
            shape = MaterialTheme.shapes.large,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .height(72.dp)
                .padding(bottom = 16.dp, start = 25.dp, end = 25.dp)
        ) {
            Text(
                text = stringResource(R.string.navigate_to_articles),
                fontSize = 18.sp
            )
        }
    }
}