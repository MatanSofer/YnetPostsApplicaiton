package com.example.ynetpostsapplication.presentation.lists_screen

sealed class ListScreenUiAction{
    data class NavigateBackWithTitle(val title: String): ListScreenUiAction()
    data class OpenWebView(val title: String): ListScreenUiAction()
}
