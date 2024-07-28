package com.example.ynetpostsapplication.presentation.lists_screen

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.ynetpostsapplication.R
import com.example.ynetpostsapplication.domain.models.Car
import com.example.ynetpostsapplication.domain.models.Culture
import com.example.ynetpostsapplication.domain.models.Sport
import com.example.ynetpostsapplication.presentation.lists_screen.composable.ListItem
import com.example.ynetpostsapplication.presentation.lists_screen.composable.Loading

@Composable
fun ListsScreen(
    navController: NavController,
    viewModel: ListScreenViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsState().value

    var selectedTabIndex by remember { mutableStateOf(0) }
    var lastClickedItemTitle by remember { mutableStateOf("") }

    val tabs = listOf(stringResource(R.string.cars_tab_text), stringResource(R.string.sport_culture_tab_text))
    BackHandler {
        navController.previousBackStackEntry
            ?.savedStateHandle
            ?.set("clicked_title",lastClickedItemTitle )
        navController.popBackStack()
    }
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        Column(modifier = Modifier.fillMaxSize()) {
            Box(modifier = Modifier.weight(1f)) {

                if(selectedTabIndex == 0 && state.firstTabIsLoading)
                    Loading()

                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    val itemsToDisplay = when (selectedTabIndex) {
                        0 -> state.cars
                        1 -> state.sports + state.culture
                        else -> emptyList()
                    }
                    items(itemsToDisplay) { item ->
                        val (title, pubDate, link) = when (item) {
                            //currently we have only 3 critical params, if we add more then it should be converted to UiDataclass
                            is Car -> Triple(item.title, item.pubDate, item.link)
                            is Sport -> Triple(item.title, item.pubDate, item.link)
                            is Culture -> Triple(item.title, item.pubDate, item.link)
                            else -> Triple(null, null, null)
                        }
                        if (title != null && pubDate != null && link != null) {
                            Column {
                                ListItem(
                                    title = title,
                                    date = pubDate,
                                    onItemClick = {
                                        viewModel.onAction(ListScreenUiAction.OpenWebView(link))
                                        lastClickedItemTitle = title
                                    }
                                )
                                Divider()
                            }
                        }
                    }
                }
            }

            TabRow(
                selectedTabIndex = selectedTabIndex,
                modifier = Modifier.fillMaxWidth()
            ) {
                tabs.forEachIndexed { index, title ->
                    Tab(
                        selected = selectedTabIndex == index,
                        onClick = { selectedTabIndex = index },
                        text = { Text(title) }
                    )
                }
            }
        }
    }
}

//@Preview
//@Composable
//private fun ListsScreenPreview() {
//    ListsScreen(
//
//    )
//}
