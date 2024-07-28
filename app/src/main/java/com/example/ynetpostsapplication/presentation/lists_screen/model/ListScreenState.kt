package com.example.ynetpostsapplication.presentation.lists_screen.model

import com.example.ynetpostsapplication.domain.models.Car
import com.example.ynetpostsapplication.domain.models.Culture
import com.example.ynetpostsapplication.domain.models.Sport

data class ListScreenState(
    val firstTabIsLoading: Boolean = false,
    val secondTabIsLoading: Boolean = false,
    val currentTile: String = "NoTitle",
    val cars: List<Car> = emptyList(),
    val sports: List<Sport> = emptyList(),
    val culture: List<Culture> = emptyList(),
)
