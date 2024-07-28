package com.example.ynetpostsapplication.presentation.open_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.ynetpostsapplication.R
import com.example.ynetpostsapplication.presentation.lists_screen.ListScreenViewModel
import com.example.ynetpostsapplication.presentation.navigation.Screen
import com.example.ynetpostsapplication.presentation.open_screen.model.OpenScreenViewModel
import kotlinx.coroutines.delay
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


@Composable
fun OpenScreen(
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
            Text(
                text = state.name,
                fontWeight = FontWeight.Bold,
                fontSize = 40.sp
            )
            Text(
                text = timeState,
                fontSize = 24.sp
            )
            Text(
                text = if(!state.lable.isNullOrEmpty()) state.lable else "There is not available title",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = if(!state.lable.isNullOrEmpty()) Color.Black else Color.Red,
                modifier = Modifier.fillMaxWidth()
            )
        }

        Button(
            onClick = { viewModel.onAction(OpenScreenUiAction.NavigateToListsScreen) },
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