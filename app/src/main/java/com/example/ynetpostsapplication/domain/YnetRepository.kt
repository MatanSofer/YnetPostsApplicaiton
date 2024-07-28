package com.example.ynetpostsapplication.domain

import com.example.ynetpostsapplication.domain.models.Car
import com.example.ynetpostsapplication.domain.models.Culture
import com.example.ynetpostsapplication.domain.models.Sport

interface YnetRepository {

    suspend fun getCarFromApi(): List<Car>
    suspend fun getCultureFromApi(): List<Culture>
    suspend fun getSportFromApi(): List<Sport>

}