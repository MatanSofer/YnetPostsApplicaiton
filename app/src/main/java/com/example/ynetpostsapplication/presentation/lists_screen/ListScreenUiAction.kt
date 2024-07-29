package com.example.ynetpostsapplication.presentation.lists_screen

sealed class ListScreenUiAction{
    data class OpenWebView(val link: String): ListScreenUiAction()
}
